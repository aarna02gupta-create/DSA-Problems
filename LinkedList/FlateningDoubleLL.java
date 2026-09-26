class FlattenNode {
    int data;
    FlattenNode next;
    FlattenNode child;
    FlattenNode prev;
    FlattenNode(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
        this.prev = null;
    }
}
class FlattenSolution {
    public FlattenNode flatten(FlattenNode head) {
        if (head == null) {
            return head;
        }

        FlattenNode curr = head;
        while (curr != null) {
            if (curr.child != null) {
                FlattenNode next = curr.next;
                FlattenNode child = curr.child;

                curr.next = child;
                child.prev = curr;
                curr.child = null;

                FlattenNode tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = next;
                if (next != null) {
                    next.prev = tail;
                }
            }
            curr = curr.next;
        }

        return head;
    }
}
public class FlateningDoubleLL {
    static FlattenNode makeNode(int val) {
        FlattenNode n = new FlattenNode(val);
        return n;
    }

    static void printList(FlattenNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data);
            if (head.next != null) sb.append(" <-> ");
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // Build: 1 <-> 2 <-> 3, with 2.child -> 7 <-> 8
        FlattenNode n1 = makeNode(1);
        FlattenNode n2 = makeNode(2);
        FlattenNode n3 = makeNode(3);
        FlattenNode n7 = makeNode(7);
        FlattenNode n8 = makeNode(8);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n2.child = n7;
        n7.next = n8; n8.prev = n7;

        System.out.print("Before flatten: ");
        // can't print nested structure easily, so just show main chain
        printList(n1);

        FlattenNode result = new FlattenSolution().flatten(n1);

        System.out.print("After flatten:  ");
        printList(result);
    }
}

        