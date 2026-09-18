class kNode {
    int val;
    kNode next;
    kNode (int val){
        this.val = val;
        this.next = null;
    }
}
    class reverseNodeKgroupSolution {            // Function to reverse nodes in groups of k
    public kNode reverseKGroup(kNode head, int k) {
        // Create a dummy node to handle edge cases
        kNode dummy = new kNode (0);
         dummy.next = head;
         kNode prevGroupEnd = dummy;   // Pointer to the tail of the last reversed group
       
        while (true) {
            // Get the k-th node in the current group
            kNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) { break; }
            kNode groupNext = kth.next; // Store the next group's head
          //reverse the current k group
            kNode prev = kth.next;
            kNode curr = prevGroupEnd.next;
            for (int i = 0; i<k; i++) {
                kNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            // Connect the previous group to the reversed group
            kNode temp = prevGroupEnd.next;  // old head of this group -> becomes tail
            prevGroupEnd.next = kth;  // link previous group's end to new head (kth)
            prevGroupEnd = temp;  // move prevGroupEnd to the tail of this reversed group
        }
        return dummy.next;
    }
 // Helper: returns the k-th node ahead of `curr`, or null if fewer than k nodes remain
    private kNode getKthNode(kNode curr, int k) {
         while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
public class reverseNodeKgroup {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        kNode head = new kNode(1);
        head.next = new kNode(2);
        head.next.next = new kNode(3);
        head.next.next.next = new kNode(4);
        head.next.next.next.next = new kNode(5);
        head.next.next.next.next.next = new kNode(6);
        head.next.next.next.next.next.next = new kNode(7);
        head.next.next.next.next.next.next.next = new kNode(8);
        head.next.next.next.next.next.next.next.next = new kNode(9);
        head.next.next.next.next.next.next.next.next.next = new kNode(10);
        
        int k = 3; // Size of the group to reverse
        reverseNodeKgroupSolution obj = new reverseNodeKgroupSolution();
        kNode res = obj.reverseKGroup(head,k);
        // Print the reversed linked list
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}