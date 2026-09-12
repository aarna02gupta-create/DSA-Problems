package LinkedList;
import java.util.Arrays;
import java.util.List;

class DeleteNthNode {
    int data;
    DeleteNthNode next;
     DeleteNthNode(int data1, DeleteNthNode next1) {
        data = data1;
        next = next1;
    }
 DeleteNthNode(int data1) {
        data = data1;
        next = null;
    }
}
class DeleteNthNodeSolution {
public void printLL(DeleteNthNode head) {   //method that prints the entire linked list
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public DeleteNthNode removeNthNodeFromEnd(DeleteNthNode head, int N) {  //Function to delete the Nth node from the end 
        DeleteNthNode dummy = new DeleteNthNode(0, head);  // Dummy node handles edge cases such as deleting the head
        
        DeleteNthNode slow = dummy;
        DeleteNthNode fast = dummy;

        // Move fast pointer N+1 steps ahead
        for (int i = 0; i <= N; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;  // Slow is now at node before target → delete target node

        return dummy.next;
    }
}

public class removeNthNode {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;
        // Create linked list
        DeleteNthNode head = new DeleteNthNode(arr.get(0));

        head.next = new DeleteNthNode(arr.get(1));
        head.next.next = new DeleteNthNode(arr.get(2));
        head.next.next.next = new DeleteNthNode(arr.get(3));
        head.next.next.next.next = new DeleteNthNode(arr.get(4));

        // Create Solution object
        DeleteNthNodeSolution sol = new DeleteNthNodeSolution();

        // Delete Nth node from end
        head = sol.removeNthNodeFromEnd(head, N);

        // Print result
        sol.printLL(head);
    }
}