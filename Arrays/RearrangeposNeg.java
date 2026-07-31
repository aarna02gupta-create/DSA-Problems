import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeposNeg {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        for(int num : nums){
            if(num < 0){
                a1.add(num);
                }
            else{
                a2.add(num);
                }
            }
            int j = 0;
            int k = 0;
for(int i = 0; i<nums.length; i++){
    if(i%2 == 0){
     nums[i] = a2.get(k++);
    }
    else{
        nums[i] = a1.get(j++);
    }
        }
        return nums;
}
public static void main(String[] args) {
    int[] nums = {3,1,-2,-5,2,-4};
    RearrangeposNeg obj = new RearrangeposNeg();
        int[] result = obj.rearrangeArray(nums);
System.out.println(Arrays.toString(result));

    }
}
