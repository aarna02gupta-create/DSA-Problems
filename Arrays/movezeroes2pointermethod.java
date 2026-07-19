import java.util.*;
public class movezeroes2pointermethod {
    public void moveZeroes(int[] nums) {
        int j = -1; // pointer to track the position of the last non-zero element
        
        // Find first zero
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0){
                j = i; // update j to the index of the first zero
                break;
            }
        }
        if (j == -1) {
            return; // no zeros found
        } 
        // Start from the next index of first zero
        for (int i=j+1; i<nums.length; i++){             
            if (nums[i] != 0){
                // swap the current non-zero element with the first zero found
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++; // move j to the next zero position
            }
        }
        // all non-zero elements have been moved to the front, and zeros are at the end
    }
    
    public static void main(String[] args) {
        movezeroes2pointermethod sol = new movezeroes2pointermethod();
        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); 
    }
}