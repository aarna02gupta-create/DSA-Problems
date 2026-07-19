public class removearrelement {

    // Two-pointer method
    public int removeElement(int[] nums, int val) {
        int i = 0; // slow pointer (write index)
        for (int j = 0; j < nums.length; j++) { // fast pointer (read index)
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
    return i; // number of elements not equal to val
    }

    public static void main(String[] args) {
        removearrelement re = new removearrelement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int newLength = re.removeElement(nums, val);
        System.out.println("New length: " + newLength);

        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
