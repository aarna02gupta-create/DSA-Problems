
class DeletemiddleNode {
    int data;
    DeletemiddleNode next;
    
         DeletemiddleNode(int data1) {
        data = data1;
        next = null;
    }
}
class deleteSolution{
 DeletemiddleNode deleteMiddle(DeletemiddleNode head) {   // Function to delete the middle node of a linked list
        DeletemiddleNode temp = head;   //initialize a temporary node to traverse the linked list
        int n = 0;      // Variable to hold the number of nodes in the linked list
// Loop to count the number of nodes in the linked list
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int mid = n/2;   // Calculate the index of the middle node
        if (mid == 0){
            return null;
        }
        temp = head;   // Reset the temporary node to the beginning of the linked list
        while (temp != null) {
            if (mid == 0){
                temp.data = temp.next.data;   // Copy the data from the next node to the current node
                temp.next = temp.next.next;   // Bypass the next node, effectively deleting it
                break;
            }
            mid--;
            temp = temp.next;    // Move to the next node in the linked list
        }
        return head;
    }
}
 public class Deletemiddle {
public static void printList(DeletemiddleNode head) {     // Function to print the linked list
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println();
    }
   
    public static void main(String[] args) {
        DeletemiddleNode head = new DeletemiddleNode(1);
        head.next = new DeletemiddleNode(2);
        head.next.next = new DeletemiddleNode(3);
        head.next.next.next = new DeletemiddleNode(4);
        head.next.next.next.next = new DeletemiddleNode(5);
        head.next.next.next.next.next = new DeletemiddleNode(6);

        System.out.print("Original List: ");
        printList(head);

        deleteSolution solution = new deleteSolution();
        head = solution.deleteMiddle(head);

        System.out.print("List after deleting middle node: ");
        printList(head);
    }
 }