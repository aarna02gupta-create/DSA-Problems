public class MaxSumsubarray {
    public static int largestSum(int[] nums) {
               // Maximum sum
        long maximum = Long.MIN_VALUE; 
        int CurrentSum = 0;
       
        for (int i = 0; i < nums.length; i++) {
            CurrentSum += nums[i];
            if (CurrentSum > maximum){
maximum = CurrentSum;
            }
            if (CurrentSum < 0){
                CurrentSum = 0;
            }
        }
        // Return the maximum subarray sum found
        return (int) maximum;
    }
public static void main (String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
             
       int res = MaxSumsubarray.largestSum(nums);
        System.out.println(" "+ res);
}
}
