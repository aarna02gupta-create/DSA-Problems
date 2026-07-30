//Find the Majority Element that occurs more than N/2 times
import java.util.HashMap;
import java.util.Map;
public class MajorityElement {
    public static int getMajorityelements(int[] nums) {
    HashMap<Integer,Integer> map = new HashMap<>();
    //count occurences of each element
    for(int num :nums) {
        //We add + 1 to increment the count and then map.put(...) saves the updated count back into the map.
        map.put(num, map.getOrDefault(num, 0)+1); 
    }
     /* Iterates through all the key-value pairs (Map.Entry) stored inside the HashMap.
entry.getKey() gets the number.
entry.getValue() gets how many times that number appeared */
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() > nums.length / 2) {
            return entry.getKey();
        }
    }
    return -1;
}
public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2,1,1,1,1,1};
      int res = MajorityElement.getMajorityelements(nums);
        System.out.println(" "+ res);
}
}