class OptimalDeleteNode {
    int data;
    OptimalDeleteNode next;
     OptimalDeleteNode(int data1, OptimalDeleteNode next1) {
        data = data1;
        next = next1;
    }

    OptimalDeleteNode(int data1) {
        data = data1;
        next = null;
    }
}
class optimalDeleteSolution{
    OptimalDeleteNode QdeleteMiddle(OptimalDeleteNode head){
        OptimalDeleteNode Slow = head;
        OptimalDeleteNode Fast = head.next.next;
        while (Fast != null && Fast.next != null) {
            Slow = Slow.next;
            Fast = Fast.next.next;
        }
    Slow.next = Slow.next.next;
    return head;
    }
    }
    public class optimalDeleteMiddle {
        public static void printList(OptimalDeleteNode head) {     // Function to print the linked list
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.println();
        }
        public static void main(String[] args) {
            OptimalDeleteNode head = new OptimalDeleteNode(1);
            head.next = new OptimalDeleteNode(2);
            head.next.next = new OptimalDeleteNode(3);
            head.next.next.next = new OptimalDeleteNode(4);
            head.next.next.next.next = new OptimalDeleteNode(5);

            System.out.print("Original List:");
            printList(head);
            optimalDeleteSolution sol = new optimalDeleteSolution();
            head = sol.QdeleteMiddle(head);
            System.out.print("List after deleting middle element:");
            printList(head);
        }
    }