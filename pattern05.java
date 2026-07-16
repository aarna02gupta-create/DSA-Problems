public class pattern05 {
    public static void main(String[] args) {
    int n=5;
    for(int i=0; i<=2*n-1; i++){
        int stars;
        if(i<=n)
            stars = i; //growing part
        else
            stars = 2*n - i; //shrinking part
    
    for (int j=1; j<=stars; j++)
     System.out.print("*");
    System.out.println();
}}}