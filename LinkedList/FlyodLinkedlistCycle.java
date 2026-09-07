  public class FlyodLinkedlistCycle {
//Definition of singly linked list:
static class ListNode {
    ListNode next;

    ListNode() {
        next = null;
    }
}

static class Solution {
    // Function to detect a loop in a linked list using the Tortoise and Hare Algorithm
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers, slow and fast,to the head of the linked list
        ListNode slow = head;
        ListNode fast = head;

        // Step 2: Traverse the linked list with the slow and fast pointers
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;

            // Check if slow and fast pointers meet
            if (slow == fast) {
                return true;  // Loop detected
            }
        }

        // If fast reaches the end of the list there is no loop
        return false;
    }

    // Main function to test the Solution
    public static void main(String[] args) {
        // Create a sample linked listwith a loop for testing
        
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode fourth = new ListNode();
        ListNode fifth = new ListNode();

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third; 

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Check if there is a loop in the linked list
        if (solution.hasCycle(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
}
