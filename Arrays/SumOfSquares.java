
public class SumOfSquares {

    static int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int val = nums[i - 1];
                sum += val * val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test1 = { 1, 2, 3, 4 };
        int[] test2 = { 2, 7, 1, 19, 18, 3 };

        System.out.println(sumOfSquares(test1)); // expected 21
        System.out.println(sumOfSquares(test2)); // expected 63
    }
}
