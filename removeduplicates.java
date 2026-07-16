public class removeduplicates {
    public static int removeDuplicates(int[] nums) {
       if(nums == null || nums.length == 0) {   // Edge case: If the array is empty, there are 0 unique elements.
            return 0;
        }
        // Pointer to place the next unique element.
        // The first element (index 0) is always unique, so we start inserting at index 1.
        int insertIndex = 1;

        // Iterate through the array starting from the second element.
        for(int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous element, we have found a new unique element.
            if(nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i];  // Place the unique element at the insertIndex.
                insertIndex++;                 // Move the insertIndex to the next position for the next unique element.
            }
        }
        return insertIndex;   // insertIndex represents the count of unique elements.
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int insertIndex = removeDuplicates(nums);
        System.out.println("Number of unique elements: " + insertIndex);
        System.out.print("Unique elements: ");
        for(int i = 0; i < insertIndex; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
