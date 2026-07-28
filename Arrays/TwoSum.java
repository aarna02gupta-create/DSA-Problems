
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoIndices(int[] arr , int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<arr.length; i++){
            int complement = target - arr[i];
            // Check if complement exists in map
            if (map.containsKey(complement)) {
               // Return indices of complement and current element
                return new int[]{map.get(complement), i};
        }
        // Store current element and its index
            map.put(arr[i], i);
    }
    return new int[] {-1,-1};
}}
class Main {
    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] arr = {2, 7, 15,11};
        int target = 9;

        int[] res = sol.twoIndices(arr, target);
        System.out.println(Arrays.toString(res)); // prints [1, 3]
    }
}