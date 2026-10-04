param(
    [Parameter(Mandatory=$true)][string]$SourceFile,
    [switch]$CompileOnly
)
$ErrorActionPreference = 'Stop'
$repoRoot = Split-Path -Parent $PSScriptRoot
$source = (Resolve-Path -LiteralPath $SourceFile).Path
$rootPrefix = [IO.Path]::GetFullPath($repoRoot).TrimEnd('\') + '\'
if (-not $source.StartsWith($rootPrefix,[StringComparison]::OrdinalIgnoreCase) -or [IO.Path]::GetExtension($source) -ne '.java') {
    throw 'Choose a Java source file inside this exercise repository.'
}
$relative = [IO.Path]::GetRelativePath($repoRoot,$source)
$hashBytes = [Security.Cryptography.SHA256]::HashData([Text.Encoding]::UTF8.GetBytes($relative))
$exerciseId = ([Convert]::ToHexString($hashBytes)).Substring(0,16)
$output = Join-Path $repoRoot ".exercise-build\$exerciseId"
$outputPrefix = Join-Path $rootPrefix '.exercise-build'
if (-not [IO.Path]::GetFullPath($output).StartsWith(([IO.Path]::GetFullPath($outputPrefix).TrimEnd('\')+'\'),[StringComparison]::OrdinalIgnoreCase)) { throw 'Unexpected build output path.' }
if (Test-Path -LiteralPath $output) { Remove-Item -LiteralPath $output -Recurse -Force }
New-Item -ItemType Directory -Path $output -Force | Out-Null
$jdk = [Environment]::GetEnvironmentVariable('JAVA_HOME','User')
if (-not $jdk) { $jdk = $env:JAVA_HOME }
$javac = Join-Path $jdk 'bin\javac.exe'
$java = Join-Path $jdk 'bin\java.exe'
$javap = Join-Path $jdk 'bin\javap.exe'
& $javac -encoding UTF-8 -d $output $source
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
Write-Output "Compiled independently: $relative"
if ($CompileOnly) { exit 0 }
$runnableClasses = @()
foreach ($classFile in (Get-ChildItem -LiteralPath $output -Recurse -Filter '*.class' -File)) {
    $className = [IO.Path]::GetRelativePath($output,$classFile.FullName).Replace('\','.').Replace('/','.') -replace '\.class$',''
    $signature = @(& $javap -public -classpath $output $className) -join "`n"
    if ($signature -match 'public static void main\(java\.lang\.String\[\]\)') { $runnableClasses += $className }
}
if ($runnableClasses.Count -ne 1) { throw "Expected one class with main(String[]); found $($runnableClasses.Count). Choose a runnable exercise file." }
& $java -classpath $output $runnableClasses[0]
exit $LASTEXITCODE
