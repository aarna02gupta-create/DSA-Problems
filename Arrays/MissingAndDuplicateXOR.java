public class MissingAndDuplicateXOR {
    public static int[] findMissingAndDuplicate(int[] arr) {
        int n = arr.length;
        int xor = 0;
        // XOR of array elements
        for(int num : arr){
            xor ^= num;
        }
        // XOR of numbers 1 to n
        for(int i = 1; i <= n; i++){
            xor ^= i;
        }
        int setBit = xor & -xor; // Rightmost set bit
        int M = 0, D = 0;

        // Divide array into two groups
        for (int num : arr){
            if((num & setBit) != 0)
                D ^= num;
            else
                M ^= num;
        }
        for (int i = 1; i <= n; i++){
            if((i & setBit) != 0)
                D ^= i;
            else
                M ^= i;
        }
         // Determine which is missing and which is duplicate
        for (int num : arr) {
            if (num == M) {
                 return new int[]{M, D};
            }
        }
            return new int[]{D, M};        // duplicate, missing
    
    }
     public static void main(String[] args) {

        int[] arr = {1, 2, 2, 4, 5};

        int[] ans = findMissingAndDuplicate(arr);

        System.out.println("Duplicate = " + ans[0]);
        System.out.println("Missing = " + ans[1]);
    }
}

