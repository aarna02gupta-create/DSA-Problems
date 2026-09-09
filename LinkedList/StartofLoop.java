import java.util.HashSet;
import java.util.Set;

public class StartofLoop {
static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

static class Solution {
    // Function to detect start of loop using Hash Map
    public ListNode detectCycle(ListNode head) {
        // Create a set to store visited nodes
        Set<ListNode> visited = new HashSet<>();

        // Traverse through the list
        while (head != null) {
            // If already visited, it's the start of the loop
            if (visited.contains(head)) {
                return head;
            }

            // Mark current node as visited
            visited.add(head);

            // Move to the next node
            head = head.next;
        }

        // No cycle found
        return null;
    }
}

public static class Main {
    public static void main(String[] args) {
        // Creating linked list nodes
        StartofLoop program = new StartofLoop();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Creating a cycle (tail connects to node index 1)
        head.next.next.next.next = head.next;

        Solution obj = new Solution();
        ListNode startNode = obj.detectCycle(head);

        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode.val);
        else
            System.out.println("No cycle found.");
    }
}

}
