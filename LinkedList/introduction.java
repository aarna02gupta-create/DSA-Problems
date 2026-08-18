class Node {
    int data;
    Node next;
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class introduction {
     // 1. Build linked list from array
     static Node constructLinkedList(int[] arr , int n) {
        Node head = new Node (arr[0]);
        Node mover = head;
        for (int i = 1; i < n; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    // 2. Print / traverse
    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 3. Length
    static int lengthOfLinkedList(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    // 4. Search
    static int searchInLinkedList(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) 
                return 1;
            temp = temp.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7};
        Node head = constructLinkedList(arr, arr.length);

        printLL(head);                                   // 2 5 8 7
        System.out.println(lengthOfLinkedList(head));     // 4
        System.out.println(searchInLinkedList(head, 8));  // 1 (found)
        System.out.println(searchInLinkedList(head, 100));// 0 (not found)
    }
}