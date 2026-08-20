public class MiddleofLL {
      public static class Node {
        public int val;
        public Node next;
// Constructor to set value and initialize next as null
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static Node findMiddle(Node head) {
        Node Slow = head;
        Node Fast = head;
        while (Fast != null && Fast.next != null) {
            Slow = Slow.next;
            Fast = Fast.next.next;
        }
        return Slow;  //When the loop ends, slow is at the middle node
    }
   
    public static void main(String[] args) {
        // Manually linking nodes without an array using method chaining
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
    
    System.out.print("Original List: ");
        Node mid = findMiddle(head);
        System.out.println("Middle node: " + mid.val);
        
    }
}
