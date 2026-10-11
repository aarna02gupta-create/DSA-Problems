public class Sqrt {

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        long left = 1;
        long right = x / 2;
        int ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                ans = (int) mid;
                left = mid + 1; // Try looking for a larger integer root
            } else {
                right = mid - 1; // Too large, look in the lower half
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Test cases to verify the solution
        int test1 = 4;
        int test2 = 8;
        int test3 = 16;

        System.out.println("Square root of " + test1 + " is: " + mySqrt(test1)); // Expected: 2
        System.out.println("Square root of " + test2 + " is: " + mySqrt(test2)); // Expected: 2 (floored)
        System.out.println("Square root of " + test3 + " is: " + mySqrt(test3)); // Expected: 4
    }
}