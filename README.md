# DSA Problems in Java

My collection of Java exercises for learning data structures, algorithms, and interview problem-solving. Solutions are organized mainly into arrays and linked lists, with additional Java basics and pattern exercises at the root.

## Browse the solutions

| Topic | Examples |
| --- | --- |
| [Arrays](Arrays/) | Two Sum, array rotation, subarray sums, next permutation, stock profit, matrix rotation, and spiral traversal |
| [Linked lists](LinkedList/) | Merge sorted lists, cycle detection, loop start/length, palindrome checking, intersection, node deletion, and reversal in groups |
| Root exercises | Pattern printing, second-largest element, and introductory Java practice |

## Selected implementations

- [Merge two sorted linked lists](LinkedList/MergeSortedLL.java) — dummy node and tail pointer
- [Reverse nodes in groups of k](LinkedList/reverseNodeKgroup.java)
- [Detect a linked-list cycle](LinkedList/FlyodLinkedlistCycle.java)
- [Count subarrays with a target sum](Arrays/CountsumSubarray.java)
- [Set matrix zeroes](Arrays/optimalSetMatrix.java)
- [Next permutation](Arrays/NextPermutation.java)

## Run an example

Install a JDK and make sure `java` and `javac` are available in your terminal.

```bash
git clone https://github.com/aarna02gupta-create/DSA-Problems.git
cd DSA-Problems/LinkedList
javac MergeSortedLL.java
java MergeSortedLL
```

Expected output:

```text
1 2 3 4 5 6
```

Compile and run one exercise at a time. These are standalone learning programs, and files may define their own helper node classes; the repository is not a single application or Maven project.

One exception is `secondlargest.java`, which calls the existing `largestarray` helper in `Arrays/largestarray.java`. From the repository root, compile both into one isolated directory:

```bash
mkdir -p out/secondlargest
javac -d out/secondlargest secondlargest.java Arrays/largestarray.java
java -cp out/secondlargest secondlargest
```

The supplied example prints a second-largest value of `19` and largest value of `44`. On PowerShell, use `New-Item -ItemType Directory -Force out/secondlargest` for the directory command.

## Keep examples isolated

To keep compiled files out of the source folders, run the same example from the repository root:

```bash
mkdir -p out/MergeSortedLL
javac -d out/MergeSortedLL LinkedList/MergeSortedLL.java
java -cp out/MergeSortedLL MergeSortedLL
```

On PowerShell, use `New-Item -ItemType Directory -Force out/MergeSortedLL` instead of `mkdir -p`. Use a separate output directory per exercise so helper classes from different solutions cannot collide.

When adding a solution, include the problem link, approach, time/space complexity, and a few edge cases in a short comment. Update the selected list only for examples you can explain and run.

## Practice approach

I use these exercises to understand pointer updates, edge cases, and the tradeoffs between brute-force and more efficient approaches. The repository is a work in progress; coverage and explanations vary by file.

[My LeetCode profile](https://leetcode.com/u/04aarnal/)

