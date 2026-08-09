public class productofArray {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: answer[i] holds prefix product (product of everything left of i)
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: sweep from right, multiply in suffix product on the fly
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];
        }

        return answer;
    }
    public static void main(String[] args) {
        // Input array
        int[] nums = {1, 2, 3, 4};

        // Create Solution object
        productofArray sol = new productofArray();

        // Call function and store result
        int[] result = sol.productExceptSelf(nums);

        // Print the product of array except self
        System.out.print("The product of array except self is: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
