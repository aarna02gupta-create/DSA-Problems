class searchrotatedSolution {
    public boolean searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // 2. ambiguous case: drop both ends
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue; // start the loop again
            }
            if (nums[left] <= nums[mid]) { // left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target is in the left half
                } else {
                    left = mid + 1; // otherwise go right
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target is in the right half
                } else {
                    right = mid - 1; // otherwise go left
                }
            }
        }
        return false;
    }
}

public class searchrotatedarray81 {
    public static void main(String[] args) {
        searchrotatedSolution obj = new searchrotatedSolution();
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 5;
        boolean answer = obj.searchRange(nums, target);
        System.out.println(answer);
    }
}