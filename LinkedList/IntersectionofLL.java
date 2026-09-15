class IntersectionNode {
    int num;
    IntersectionNode next;
    IntersectionNode(int val) {
        num = val;
        next = null;
    }
}

class IntersectionSolution {
    // Utility function to insert node at the end of the linked list
    public void insertNode(IntersectionNode head, int val) {
        IntersectionNode newNode = new IntersectionNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        IntersectionNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Utility function to check presence of intersection
    public IntersectionNode intersectionPresent(IntersectionNode head1, IntersectionNode head2) {
        IntersectionNode d1 = head1;
        IntersectionNode d2 = head2;

        // Traverse both lists, when one reaches the end, redirect it to the head of the other list
        while (d1 != d2) {
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }

        return d1;  // If they meet, return the intersection node, otherwise NULL
    }

    // Utility function to print linked list
    public void printList(IntersectionNode head) {
        while (head != null && head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        if (head != null) {
            System.out.print(head.num);
        }
        System.out.println();
    }
}

public class IntersectionofLL {
    public static void main(String[] args) {
        IntersectionSolution sol = new IntersectionSolution();

        // Creation of both lists
        IntersectionNode head = new IntersectionNode(1);
        sol.insertNode(head, 3);
        sol.insertNode(head, 1);
        sol.insertNode(head, 2);
        sol.insertNode(head, 4);
        IntersectionNode head1 = head;
        head = head.next.next.next;  // Intersection point
        IntersectionNode headSec = new IntersectionNode(3);
        IntersectionNode head2 = headSec;
        headSec.next = head;  // Creating intersection

        // Printing the lists
        System.out.print("List1: ");
        sol.printList(head1);
        System.out.print("List2: ");
        sol.printList(head2);

        // Checking if intersection is present
        IntersectionNode answerNode = sol.intersectionPresent(head1, head2);
        if (answerNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("The intersection point is " + answerNode.num);
        }
    }
}
