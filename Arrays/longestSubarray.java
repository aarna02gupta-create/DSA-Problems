public class longestSubarray {
    public static int GetlongestSubarray(int[] nums, long k) {
     int left = 0;
     long current_sum = 0;
     int maxlen = 0;
     for (int right = 0; right<nums.length; right++) {
        current_sum += nums[right];
     
     while( left<= right && current_sum > k){
      current_sum -= nums[left];
                left++;
            }
            if(current_sum == k){
                maxlen = Math.max(maxlen, right - left + 1);
            }
     }
     return maxlen;
    }
    public static void main(String[] args) {
        // example usage
        int[] nums = { 2, 3, 5, 1, 9};
        long k = 6;
        System.out.println(GetlongestSubarray(nums, k));
    }
}