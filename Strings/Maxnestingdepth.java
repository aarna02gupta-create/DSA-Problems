import java.util.Stack;
import java.util.Scanner;

public class Maxnestingdepth {
    public static int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                max = Math.max(max, stack.size());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // create a keyboard reader
        System.out.println("Enter a string with parentheses: ");
        String s = sc.nextLine(); // read one whole line as a string
        int depth = maxDepth(s);
        System.out.println("Maximum nesting depth: " + depth);
        sc.close();
    }
}