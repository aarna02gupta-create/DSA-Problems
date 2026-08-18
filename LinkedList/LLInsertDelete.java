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

public class LLInsertDelete {

    // ---------- helpers ----------
    static Node constructLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ---------- DELETIONS ----------
    static Node deleteHead(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    static Node deleteTail(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
        return head;
    }

    static Node deleteKthElement(Node head, int k) {
        if (head == null) return null;
        if (k == 1) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }
        int cnt = 0;
        Node temp = head, prev = null;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    static Node deleteByValue(Node head, int val) {
        if (head == null) return null;
        if (head.data == val) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }
        Node prev = head, temp = head.next;
        while (temp != null) {
            if (temp.data == val) {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // ---------- INSERTIONS ----------
    static Node insertAtHead(Node head, int val) {
        return new Node(val, head);
    }

    static Node insertAtTail(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) return newNode;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    static Node insertAtKthPosition(Node head, int val, int k) {
        if (k == 1) return new Node(val, head);
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k - 1) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    static Node insertBeforeValue(Node head, int val, int target) {
        if (head == null) return null;
        if (head.data == target) return new Node(val, head);
        Node prev = head, temp = head.next;
        while (temp != null) {
            if (temp.data == target) {
                Node newNode = new Node(val, temp);
                prev.next = newNode;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // ---------- driver ----------
    public static void main(String[] args) {
        Node head = constructLL(new int[]{10, 20, 30, 40, 50});
        printLL(head);                          // 10 -> 20 -> 30 -> 40 -> 50 -> null

        head = deleteHead(head);
        printLL(head);                          // 20 -> 30 -> 40 -> 50 -> null

        head = insertAtHead(head, 10);
        printLL(head);                          // 10 -> 20 -> 30 -> 40 -> 50 -> null

        head = deleteTail(head);
        printLL(head);                          // 10 -> 20 -> 30 -> 40 -> null

        head = insertAtTail(head, 50);
        printLL(head);                          // 10 -> 20 -> 30 -> 40 -> 50 -> null

        head = deleteKthElement(head, 3);
        printLL(head);                          // 10 -> 20 -> 40 -> 50 -> null

        head = insertAtKthPosition(head, 30, 3);
        printLL(head);                          // 10 -> 20 -> 30 -> 40 -> 50 -> null

        head = deleteByValue(head, 40);
        printLL(head);                          // 10 -> 20 -> 30 -> 50 -> null

        head = insertBeforeValue(head, 40, 50);
        printLL(head);                          // 10 -> 20 -> 30 -> 40 -> 50 -> null
    }
}
