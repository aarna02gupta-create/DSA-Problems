
    import java.util.Stack;

class PalindromeNode {
    int val;
    PalindromeNode next;

    PalindromeNode(int val1, PalindromeNode next1) {
        val = val1;
        next = next1;
    }

    PalindromeNode(int val1) {
        val = val1;
        next = null;
    }
}

class PalindromeSolution {

    public boolean isPalindrome(PalindromeNode head) {

        Stack<Integer> st = new Stack<>();

        // Store all linked list values in the stack
        PalindromeNode temp = head;

        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        // Compare linked list values with stack values
        temp = head;

        while (temp != null) {

            if (temp.val != st.peek()) {
                return false;
            }

            st.pop();
            temp = temp.next;
        }

        return true;
    }
}

public class Palindrome234 {

    public static void main(String[] args) {

        // Create linked list:
        // 1 -> 2 -> 3 -> 2 -> 1

        PalindromeNode head = new PalindromeNode(1);
        head.next = new PalindromeNode(2);
        head.next.next = new PalindromeNode(3);
        head.next.next.next = new PalindromeNode(2);
        head.next.next.next.next = new PalindromeNode(1);

        PalindromeSolution sol = new PalindromeSolution();

        boolean result = sol.isPalindrome(head);

        if (result) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}