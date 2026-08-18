import java.util.HashSet;
public class LCS {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        //put every number into the set
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        //loop over the set
        for (int x : set) {
            //check if x-1 is not in the set, if it is not, then x is the start of a sequence
            if (!set.contains(x - 1)) {      //"Is x - 1 absent from the set?"
                int currentNum = x;
                int currentlen = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentlen++;
                }
                longestStreak = Math.max(longestStreak, currentlen);
            }
        }
        return longestStreak;
    }
        public static void main(String[] args) {
            int[] nums = {100, 4, 200, 1, 3, 2};
            LCS obj = new LCS();
            int so = obj.longestConsecutive(nums);
            System.out.println("The longest consecutive sequence has length: " + so);
        }
}