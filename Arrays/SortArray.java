public class SortArray { // Capitalized class name (PascalCase)
    
    public void sortZeroOneTwo(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Helper method for swapping elements to make code cleaner
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        SortArray obj = new SortArray();
        int[] nums = {2, 0, 2, 1, 1, 0};

        obj.sortZeroOneTwo(nums);

        // Output result
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}