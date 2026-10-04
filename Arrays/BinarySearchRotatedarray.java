
class RotatedSolution {
    public int searchRange(int[] nums, int target) {
        int left = 0; // start of the search range
        int right = nums.length - 1; // end of the search range

        while (left <= right) { // keep going while the range is not empty

            int mid = left + (right - left) / 2; // middle index

            if (nums[mid] == target) { // step 1: found it
                return mid;
            }

            if (nums[left] <= nums[mid]) { // step 2: left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // step 3: target is in the left half, go left
                } else {
                    left = mid + 1; // otherwise go right
                }
            } else { // step 2: right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target is in the right half, go right
                } else {
                    right = mid - 1; // otherwise go left
                }
            }
        }

        return -1;
    }
}

public class BinarySearchRotatedarray {
    public static void main(String[] args) {
        RotatedSolution solution = new RotatedSolution();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 }; // Example rotated sorted array
        int target = 4; // Target to search for
        int result = solution.searchRange(nums, target); // Perform the search
        System.out.println("Target found at index: " + result); // Output the result
    }
}