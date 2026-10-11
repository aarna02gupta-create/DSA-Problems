
//Given the sorted rotated array nums of unique elements, return the minimum element of this array.
import java.util.Arrays;

class FindMinRotatedSolution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}

public class MinRotatedArray {
    public static void main(String[] args) {
        FindMinRotatedSolution solution = new FindMinRotatedSolution();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 }; // Example rotated sorted array
        int minElement = solution.findMin(nums); // Find the minimum element
        System.out.println("Minimum element in the rotated array: " + minElement); // Output the result
    }
}