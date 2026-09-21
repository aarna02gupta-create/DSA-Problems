class MergeNode {
    int data;
    MergeNode next;
    MergeNode(int data1) {
        data = data1;
        next = null;
    }
}
class mergeSolution {
    public MergeNode merge(MergeNode head1, MergeNode head2) {
        MergeNode dummy = new MergeNode(-1);
        MergeNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }
}
public class MergeSortedLL {
    public static void main(String[] args) {
        MergeNode head1 = new MergeNode(1);
        head1.next = new MergeNode(3);
        head1.next.next = new MergeNode(5);

        MergeNode head2 = new MergeNode(2);
        head2.next = new MergeNode(4);
        head2.next.next = new MergeNode(6);

        mergeSolution res = new mergeSolution();
        MergeNode mergelist = res.merge(head1, head2);
        while (mergelist != null) {
            System.out.print(mergelist.data + " ");
            mergelist = mergelist.next;
        }
    }
}