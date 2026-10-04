import java.util.HashMap;

class Node {
    int key;
    int value;

    Node previous;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> cache;

    // Dummy nodes
    private Node leftDummy;
    private Node rightDummy;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        leftDummy = new Node(0, 0);
        rightDummy = new Node(0, 0);

        // LEFT <-> RIGHT
        leftDummy.next = rightDummy;
        rightDummy.previous = leftDummy;
    }

    // Remove a node from the linked list
    private void remove(Node currentNode) {
        Node previousNode = currentNode.previous;
        Node nextNode = currentNode.next;
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
    }

    // Insert node just before rightDummy
    // This makes it the Most Recently Used node.
    private void insert(Node currentNode) {

        Node previousNode = rightDummy.previous;
        previousNode.next = currentNode;
        currentNode.previous = previousNode;
        currentNode.next = rightDummy;

        rightDummy.previous = currentNode;
    }

    public int get(int key) {

        if (cache.containsKey(key)) {

            Node currentNode = cache.get(key);

            // Move this node to the MRU position
            remove(currentNode);
            insert(currentNode);
            return currentNode.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        // If key already exists,
        // remove its old node from the linked list.
        if (cache.containsKey(key)) {

            Node existingNode = cache.get(key);

            remove(existingNode);
        }

        // Create a new node
        Node newNode = new Node(key, value);

        // Add/update HashMap
        cache.put(key, newNode);
        // New node becomes MRU
        insert(newNode);
        // If capacity is exceeded,
        // remove the LRU node.
        if (cache.size() > capacity) {

            Node leastRecentlyUsed = leftDummy.next;
            remove(leastRecentlyUsed);   
            cache.remove(leastRecentlyUsed.key);
        }
    }
}