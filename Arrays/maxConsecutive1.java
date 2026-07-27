//Given a binary array nums, return the maximum number of consecutive 1's in the array.
public class maxConsecutive1 {
    public int Consecutivemax(int[] nums) {   //Takes a binary array as input.
        int max = 0;
        int count = 0;

        for (int num : nums) {           // visits every element once
            if (num == 1) {
                count++;
            max = Math.max(max, count);  //Math.max(a, b) is a built-in Java method that returns the larger (maximum) of the two values.
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1};
        maxConsecutive1 obj = new maxConsecutive1();    //obj is a reference variable that can refer to objects of type maxConsecutive1

        System.out.println(" " + obj.Consecutivemax(arr));
    }
}