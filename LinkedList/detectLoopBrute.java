import java.util.*;
class Node {
    int data;     
    Node next;            // Pointer to the next node in the list

    // Constructor with both data and next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }
    // Constructor with only data as a parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}
// Solution class with detectLoop function
class Solution {
    // function to detect loop in linked list
    public boolean detectLoop(Node head) {
        // Initialize a pointer 'temp' at the head of the linked list
        Node temp = head;
          // Create a map to keep track of encountered nodes
        HashMap<Node, Integer> nodeMap = new HashMap<>();

        // Step 2: Traverse the linked list
        while (temp != null) {
            // If the node is already in the map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            // Store the current node in the map
            nodeMap.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }
}
// Driver class
public class detectLoopBrute {
    public static void main(String[] args) {
        // Create a sample linked list with a loop for testing
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next;   // Create a loop
        Solution sol = new Solution();

        // Check if there is a loop in the linked list
        if (sol.detectLoop(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
