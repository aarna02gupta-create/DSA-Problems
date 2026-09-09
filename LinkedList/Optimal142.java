  class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;   //
        this.next = null;
    }
}

class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;          
            fast = fast.next.next;     

            // Cycle found
            if (slow == fast) {

                // Step 2: Find cycle starting point
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}

public class Optimal142 {

    public static void main(String[] args) {

        // Create linked list
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Create cycle
        // 3 → 2 → 0 → -4
        //     ↑         |
        //     └─────────┘
        head.next.next.next.next = head.next;

        // Create Solution object
        Solution sol = new Solution();

        // Find cycle
        ListNode result = sol.detectCycle(head);

        // Print result
        if (result != null) {
            System.out.println("Cycle starts at: " + result.val);
        } else {
            System.out.println("No cycle");
        }
    }
}
                // This import has been removed
