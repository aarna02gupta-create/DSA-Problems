public class MaxAveragesubarray {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int maxSum = windowSum;
        for (int i = k ; i< n-1; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        MaxAveragesubarray obj = new MaxAveragesubarray();
        double result = obj.findMaxAverage(nums, k);
        System.out.println("Maximum average of subarray of size " + k + " is: " + result);
    }
}
