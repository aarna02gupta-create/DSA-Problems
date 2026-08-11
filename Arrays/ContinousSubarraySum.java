import java.util.HashMap;
import java.util.Map;

public class ContinousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();  //Map to store (remainder, earliest_index)
       remainderMap.put(0,-1);  // Initialize with remainder 0 at index -1 to handle cases where the subarray starts from index 0
 int runningSum=0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int remainder = runningSum % k; // Calculate the remainder of the running sum when divided by k

            if (remainder < 0) { // Handle negative remainders
                remainder += k;
            }
            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) >= 2) { // Check if the subarray length is at least 2
                    return true;
                }}
                else {
                    remainderMap.put(remainder, i);   //we only put the remainder into the map if it doesn't exist yet
                }
}
return false;
    }
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7}; 
        int k = 6;
        ContinousSubarraySum obj = new ContinousSubarraySum();
        boolean result = obj.checkSubarraySum(nums, k);
        System.out.println( result);
    }
}