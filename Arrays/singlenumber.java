//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
public class singlenumber {
    public static int findSingleElement(int [] arr) {
   int xor1 = 0;
   // XOR all elements — duplicates cancel each other out
        for (int num : arr) {
            xor1 = xor1 ^ num;
    }
   return xor1;
}
public static void main(String[] args) {
    int [] arr = {2, 2, 1, 1, 4};
    System.out.println(+findSingleElement(arr));
}
}