
//Given the sorted rotated array nums of unique elements, return the minimum element of this array.
import java.util.Arrays;

class FindMinRotatedSolution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Note: using left < right instead of left <= right
        // because we are narrowing down to a single element.
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is greater than the right end, the array is rotated
            // and the pivot (minimum) must be somewhere to the right.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Otherwise, the right half is sorted normally, meaning the
            // minimum is either at mid or somewhere in the left half.
            else {
                right = mid;
            }
        }

        // At the end of the loop, left == right, pointing to the minimum element
        return nums[left];
    }
}

public class MinRotatedArray {
    public static void main(String[] args) {
        FindMinRotatedSolution obj = new FindMinRotatedSolution();

        // Test Case 1
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int answer1 = obj.findMin(nums1);

        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("Minimum element: " + answer1); // Expected: 0
        System.out.println("-------------------------");

        // Test Case 2 (Rotated slightly)
        int[] nums2 = { 3, 4, 5, 1, 2 };
        int answer2 = obj.findMin(nums2);

        System.out.println("Array: " + Arrays.toString(nums2));
        System.out.println("Minimum element: " + answer2); // Expected: 1
    }
}
