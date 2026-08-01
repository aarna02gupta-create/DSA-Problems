public class SortArray { 
    public void sortZeroOneTwo(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
               int temp = nums[low];
               nums[low] = nums[mid];
               nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {                // nums[mid] == 2
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        SortArray obj = new SortArray();
        int nums[] = {2, 0, 2, 1, 1, 0};
        obj.sortZeroOneTwo(nums);   //Calls the sorting method on nums
        for (int num : nums) {
        System.out.print(num + " ");
    }
}
}