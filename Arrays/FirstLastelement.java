
class firstLastPositionNode {
    int val;
    firstLastPositionNode left;
    firstLastPositionNode right;

    // Constructor: a special method used to create a new object of this class. It
    // initializes the node with a given value.
    firstLastPositionNode(int val) {
        this.val = val; // 'this.val' refers to the current object's val field.
        this.left = null; // Set left child to null because it has no child yet.
        this.right = null; // Set right child to null because it has no child yet.
    }
}

// This class contains the binary search logic to find the first and last
// position of a target value.
class FirstLastPositionSolution {

    // This method returns an array containing the first and last index of the
    // target.
    // int[] means the return type is an array of integers.
    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, target, true); // Search for the first occurrence.
        int last = search(nums, target, false); // Search for the last occurrence.
        return new int[] { first, last }; // Create and return an array like [first, last].
    }

    // This helper method performs a modified binary search. 'findFirst' decides
    // whether we are searching for the first or last occurrence.
    private int search(int[] nums, int target, boolean findFirst) {
        int left = 0; // Starting index of the search space.
        int right = nums.length - 1; // Ending index of the search space.
        int ans = -1; // Default answer if target is not found.

        // Run the loop while left pointer is still before or equal to right.
        while (left <= right) {
            int mid = left + (right - left) / 2; // Middle index to avoid overflow in large arrays.

            // If the middle value matches the target, we found a candidate position.
            if (nums[mid] == target) {
                ans = mid; // Save the current index as a possible answer.
                if (findFirst)
                    right = mid - 1; // Move left to find an earlier match.
                else
                    left = mid + 1; // Move right to find a later match.
            } else if (nums[mid] < target) { // If middle value is smaller than target, move right side.
                left = mid + 1; // Search in the right half.
            } else { // If middle value is greater than target, move left side.
                right = mid - 1; // Search in the left half.
            }
        }
        return ans; // Return the index found after the search is complete.
    }
}

// This is the main public class of the program.
public class FirstLastelement {

    // The entry point of any Java program.
    // 'args' stores command line arguments passed while running the program.
    public static void main(String[] args) {
        FirstLastPositionSolution res = new FirstLastPositionSolution(); // Create an object of the solution class.
        int[] nums = { 5, 7, 7, 8, 8, 10 }; // Array to search in.
        int target = 8; // Value we want to find.

        int[] result = res.searchRange(nums, target); // Call the method to get first and last positions.
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // Print the result in [first, last] format.
    }
}