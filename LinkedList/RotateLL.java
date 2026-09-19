class rotateNode {
    int val;
    rotateNode next;
    rotateNode (int x){
        val = x;
        next = null;
    }
}
    // Function to rotate the linked list to the right by k places
class rotateSolution {
    public rotateNode rotateRight(rotateNode head, int k) {
        // EDGE CASE: If list is empty or only one node or k = 0, return head 
        if (head == null || head.next == null || k == 0)
            return head;
        int len = 1;
        rotateNode tail = head;

        // Traverse to find tail and calculate length
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k = k % len;       // Handle cases where k is larger than the length of the list
        if (k == 0) return head; // No rotation needed

        tail.next = head; // Connect the tail to the head to form a circular list
        rotateNode newTail = head;   //	newTail = head (1)

        for (int i = 0; i < len - k - 1; i++) {  // loop runs len - k - 1 = 5-2-1 = 2 times: 
           newTail = newTail.next;
        }                                       //  newTail is at node 2, then newTail = 3
        rotateNode newHead = newTail.next;  //look at what newTail.next is pointing to, and call it newHead.

        newTail.next = null; // Break the circle; destroys the connection from 3 to 4
        return newHead;
    }
}
public class RotateLL {
    public static void main(String[] args) {
        // Creating linked list: 1->2->3->4->5
        rotateNode head = new rotateNode(1);
        head.next = new rotateNode(2);
        head.next.next = new rotateNode(3);
        head.next.next.next = new rotateNode(4);
        head.next.next.next.next = new rotateNode(5);
 int k = 2;
 rotateSolution sol = new rotateSolution();
        rotateNode rotatedHead = sol.rotateRight(head, k);
        // Print the rotated linked list
        rotateNode current = rotatedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}