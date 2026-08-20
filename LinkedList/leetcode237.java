public class leetcode237 {
    public static class Node {
        public int val;
        public Node next;
// Constructor to set value and initialize next as null
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // LeetCode 237 Solution: Delete given node directly without head
    public static void deleteNode(Node node) {
        // Copy the value of the next node into current node
        node.val = node.next.val;
        // Skip/delete the next node
        node.next = node.next.next;
    }

    // Helper method to print the linked list
    public static void printLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Manually linking nodes without an array using method chaining
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(1);
        head.next.next.next = new Node(9);

        System.out.print("Original List: ");
        printLL(head);

        // Deleting node with value 5 directly using its reference
        Node nodeToDelete = head.next; // Node containing 5
        deleteNode(nodeToDelete);


        System.out.print("Linked List after deleting 5: ");
        printLL(head);
    }
}
