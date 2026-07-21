//XOR Method
public class XORmissingElement {
    public static int XORmissingNumber(int[] arr) {
        int n = arr.length + 1;
        int xor1 = 0;
        int xor2 = 0;

        for (int i = 0; i <= n; i++) {
            xor1 = xor1 ^ i;
        }

        for (int num : arr) {
            xor1 = xor1 ^ num;
        }

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        System.out.println("The missing number is: " + XORmissingNumber(arr));
    }
}
