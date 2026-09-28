class insertSearchNode {
    int val;
    insertSearchNode left;
    insertSearchNode right;
 
    insertSearchNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class insertSearchSolution {
   public int search(int[] nums, int target) {
      
        int left = 0;
       int right = nums.length - 1;

       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (nums[mid] == target) {
               return mid;
           }
           else if (nums[mid] < target) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }

       return left;
   }
}
public class searchInsert {
    public static void main(String[] args) {
        insertSearchSolution res = new insertSearchSolution();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int result = res.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);
    }
}