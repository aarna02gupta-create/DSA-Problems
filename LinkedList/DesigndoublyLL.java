
    class DoublyLL {
        private static class designNode {
        int val;
        designNode prev;
        designNode next;
        designNode(int val) {
            this.val = val;
        }
    }

    private designNode dummyHead, dummyTail;
    private int size;

    public DoublyLL() {
        dummyHead = new designNode(-1);
        dummyTail = new designNode(-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        size = 0;
    }

    private designNode getNode(int index) {
        if (index < 0 || index >= size) return null;
        designNode curr;
        if (index < size / 2) {
            curr = dummyHead.next;
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = dummyTail.prev;
            for (int i = 0; i < size - 1 - index; i++) curr = curr.prev;
        }
        return curr;
    }

    private void insertBefore(designNode node, int val) {
        designNode newNode = new designNode(val);
        designNode prevNode = node.prev;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = node;
        node.prev = newNode;

        size++;
    }

    public int get(int index) {
        designNode node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        insertBefore(dummyHead.next, val);
    }

    public void addAtTail(int val) {
        insertBefore(dummyTail, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        designNode target = (index < size) ? getNode(index) : dummyTail;
        insertBefore(target, val);
    }

    public void deleteAtIndex(int index) {
        designNode node = getNode(index);
        if (node == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
public static void main(String[] args) {
        DoublyLL myLinkedList = new DoublyLL();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(myLinkedList.get(1));            // return 2
        myLinkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(myLinkedList.get(1));            // return 3
    }
}