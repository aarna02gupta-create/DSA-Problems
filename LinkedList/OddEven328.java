
class OddEvenNode {
    int data;
    OddEvenNode next;
    public OddEvenNode(int data1) {
        data = data1;
     next = null;
    }
}
class Solution {

    // Function to segregate even and odd nodes in a linked list
    public OddEvenNode OddEven328(OddEvenNode head) {

        if (head == null || head.next == null) return head;  // Edge case: If list is empty or has only one node

        // Create pointers for the heads and tails of even and odd lists
        OddEvenNode evenHead = null, evenTail = null;
        OddEvenNode oddHead = null, oddTail = null;

        // Pointer to traverse the list
        OddEvenNode current = head;

        // Traverse the linked list
        while (current != null) {
            if (current.data % 2 == 0) {
                if (evenTail == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            } else {
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    if (oddTail != null) {
                        oddTail.next = current;
                    }
                    oddTail = current;
                }
            }
            current = current.next;
        }

        // Connect the even and odd lists
        if (evenHead != null && evenTail != null) {
            evenTail.next = oddHead;     //4.next = 17
        }
        if (oddTail != null) {
    oddTail.next = null;      // terminates the list properly
}

        // Return the head of the segregated list
        return evenHead != null ? evenHead : oddHead;
    }
}
class OddEvenMain {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Creating linked list: 17 -> 15 -> 8 -> 12 -> 10 -> 5 -> 4
        OddEvenNode head = new OddEvenNode(17);
        head.next = new OddEvenNode(15);
        head.next.next = new OddEvenNode(8);
        head.next.next.next = new OddEvenNode(12);
        head.next.next.next.next = new OddEvenNode(10);
        head.next.next.next.next.next = new OddEvenNode(5);
        head.next.next.next.next.next.next = new OddEvenNode(4);

        // Call segregation function
        OddEvenNode newHead = sol.OddEven328(head);

        // Print result
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }
}