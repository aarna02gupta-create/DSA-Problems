class LoopLength {
    int data;
    LoopLength next;
    LoopLength(int val) {
        data = val;
        next = null;
    }
}
class Solution {
    public int detectCycle(LoopLength head) {
        LoopLength slow = head;
        LoopLength fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                int count = 1;    // loop found, count length
                LoopLength temp = slow.next;
                while (temp != fast) {
                    temp = temp.next;
                    count++;
                }
                return count;        // return length of loop
            }
        }
        return 0;  // no loop found
    }
}
class Main {
    public static void main(String[] args) {
        // Create linked list
        LoopLength head = new LoopLength(1);
        head.next = new LoopLength(2);
        head.next.next = new LoopLength(3);
        head.next.next.next = new LoopLength(4);
        head.next.next.next.next = new LoopLength(5);

        // Create a loop for testing
        head.next.next.next.next.next = head.next;      // 5 points to 2

        Solution sol = new Solution();
        int loopLength = sol.detectCycle(head);
        if (loopLength > 0) {
            System.out.println("Loop length is: " + loopLength);
        } else {
            System.out.println("No loop found.");
        }
    }
}