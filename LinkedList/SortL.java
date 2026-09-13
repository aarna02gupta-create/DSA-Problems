class MergeSortNode {
    // Data stored in the node
    int data;

    // Pointer to the next node
    MergeSortNode next;

    // Constructor with data and next pointer
    MergeSortNode(int data1, MergeSortNode next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data
    MergeSortNode(int data1) {
        data = data1;
        next = null;
    }
}

// Solution class contains merge sort logic
class SortLLSolution {
    // Function to merge two sorted linked lists
    public MergeSortNode mergeTwoSortedLinkedLists(MergeSortNode list1, MergeSortNode list2) {
        // Create a dummy node
        MergeSortNode dummyNode = new MergeSortNode(-1, null);

        // Temp pointer to build merged list
        MergeSortNode temp = dummyNode;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            // Choose smaller node
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move temp pointer
            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Return head of merged list
        return dummyNode.next;
    }

    // Function to find middle of linked list
    public MergeSortNode findMiddle(MergeSortNode head) {
        // If list empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Slow and fast pointers
        MergeSortNode slow = head;
        MergeSortNode fast = head.next;

        // Move fast twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return middle node
        return slow;
    }

    // Function to perform merge sort
    public MergeSortNode sortLL(MergeSortNode head) {
        // Base case: empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle node
        MergeSortNode middle = findMiddle(head);

        // Split into two halves
        MergeSortNode right = middle.next;
        middle.next = null;
        MergeSortNode left = head;

        // Recursively sort both halves
        left = sortLL(left);
        right = sortLL(right);

        // Merge sorted halves
        return mergeTwoSortedLinkedLists(left, right);
    }
}

// Main class to run the program
public class SortL {
    // Function to print linked list
    static void printLinkedList(MergeSortNode head) {
        // Temp pointer to traverse
        MergeSortNode temp = head;

        // Traverse and print nodes
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create linked list: 3 -> 2 -> 5 -> 4 -> 1
        MergeSortNode head = new MergeSortNode(3, null);
        head.next = new MergeSortNode(2, null);
        head.next.next = new MergeSortNode(5, null);
        head.next.next.next = new MergeSortNode(4, null);
        head.next.next.next.next = new MergeSortNode(1, null);

        // Print original list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Create SortLLSolution object
        SortLLSolution obj = new SortLLSolution();

        // Sort the linked list
        head = obj.sortLL(head);

        // Print sorted list
        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }
}
