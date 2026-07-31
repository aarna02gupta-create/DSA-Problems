//You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
//Return the sum of all the unique elements of nums.

import java.util.*;

public class Uniquesum {
    public int SumofUniqueElements(int[] nums){
    int sum = 0;
    for (int i = 0; i < nums.length; i++){
        int count = 0;
        for(int j = 0; j < nums.length; j++){
            if (nums[j] == nums[i]){
                count++;
            }
        }
        if (count == 1){
            sum += nums[i];
        }
    }    
    return sum; 
    }
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 2};
        Uniquesum var = new Uniquesum();
        int sum = var.SumofUniqueElements(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(" " + sum);
    }
}
