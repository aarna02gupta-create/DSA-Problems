class Node {
    int data;
    Node next;
    Node prev;

    Node(int data1, Node next1, Node prev1) {
        data = data1;
        next = next1;
        prev = prev1;
    }

    Node(int data1) {
        data = data1;
        next = null;
        prev = null;
    }
}

public class DoublyLL {

    // ---------- CONSTRUCT ----------
    static Node constructDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, mover); // prev = mover
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    // ---------- PRINT (forward) ----------
    static void printDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ---------- PRINT (backward, from tail) ----------
    static void printReverseDLL(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next; // reach tail
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // ================= INSERTIONS =================

    static Node insertAtHead(Node head, int val) {
        Node newNode = new Node(val, head, null);
        if (head != null) head.prev = newNode;
        return newNode;
    }

    static Node insertAtTail(Node head, int val) {
        if (head == null) return new Node(val);
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        Node newNode = new Node(val, null, temp);
        temp.next = newNode;
        return head;
    }

    static Node insertBeforeKthElement(Node head, int val, int k) {
        if (k == 1) return insertAtHead(head, val);

        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("k is out of range, no insertion done.");
            return head;
        }
        Node prevNode = temp.prev;
        Node newNode = new Node(val, temp, prevNode);
        prevNode.next = newNode;
        temp.prev = newNode;
        return head;
    }

    // insert before a directly-given node reference (O(1))
    static void insertBeforeNode(Node node, int val) {
        Node prevNode = node.prev;
        Node newNode = new Node(val, node, prevNode);
        if (prevNode != null) prevNode.next = newNode;
        node.prev = newNode;
    }

    // ================= DELETIONS =================

    static Node deleteHead(Node head) {
        if (head == null || head.next == null) return null;
        Node prevHead = head;
        head = head.next;
        head.prev = null;
        prevHead.next = null;
        return head;
    }

    static Node deleteTail(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        Node newTail = temp.prev;
        newTail.next = null;
        temp.prev = null;
        return head;
    }

    static Node deleteKthElement(Node head, int k) {
        if (head == null) return null;

        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("k is out of range, no deletion done.");
            return head;
        }

        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        if (prevNode == null) return deleteHead(head);           // k == 1
        if (nextNode == null) { prevNode.next = null; return head; } // last node

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        temp.next = null;
        temp.prev = null;
        return head;
    }

    // delete a directly-given node reference (O(1))
    static void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if (prevNode == null) { if (nextNode != null) nextNode.prev = null; return; } // head
        if (nextNode == null) { prevNode.next = null; return; }                        // tail

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    
    public static void main(String[] args) {

        // 1. Construct
        Node head = constructDLL(new int[]{10, 20, 30, 40, 50});
        System.out.print("Initial DLL:        ");
        printDLL(head);
        System.out.print("Reverse print:       ");
        printReverseDLL(head);

        // 2. Insert at head
        head = insertAtHead(head, 5);
        System.out.print("After insertAtHead:  ");
        printDLL(head);

        // 3. Insert at tail
        head = insertAtTail(head, 60);
        System.out.print("After insertAtTail:  ");
        printDLL(head);

        // 4. Insert before k-th element (k = 3)
        head = insertBeforeKthElement(head, 100, 3);
        System.out.print("After insertBeforeKth(k=3, val=100): ");
        printDLL(head);

        // 5. Insert before a known node reference (find node with data=40, insert 999 before it)
        Node temp = head;
        while (temp != null && temp.data != 40) temp = temp.next;
        if (temp != null) insertBeforeNode(temp, 999);
        System.out.print("After insertBeforeNode(node=40, val=999): ");
        printDLL(head);

        // 6. Delete head
        head = deleteHead(head);
        System.out.print("After deleteHead:    ");
        printDLL(head);

        // 7. Delete tail
        head = deleteTail(head);
        System.out.print("After deleteTail:    ");
        printDLL(head);

        // 8. Delete k-th element (k = 3)
        head = deleteKthElement(head, 3);
        System.out.print("After deleteKth(k=3): ");
        printDLL(head);

        // 9. Delete a known node reference (find node with data=999, delete it)
        Node target = head;
        while (target != null && target.data != 999) target = target.next;
        if (target != null) deleteNode(target);
        System.out.print("After deleteNode(node=999): ");
        printDLL(head);

        System.out.print("Final reverse print: ");
        printReverseDLL(head);
    }
}