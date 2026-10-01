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

## Practice approach

I use these exercises to understand pointer updates, edge cases, and the tradeoffs between brute-force and more efficient approaches. The repository is a work in progress; coverage and explanations vary by file.

[My LeetCode profile](https://leetcode.com/u/04aarnal/)
