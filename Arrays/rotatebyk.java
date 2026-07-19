public class rotatebyk {
    public static void rotatearray(int[] arr, int k) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        k = k % n;
        if (k == 0) return;

        // Step 1: Copy first k elements
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        // Step 2: Shift remaining elements left
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];   // ✅ use arr, not temp
        }

        // Step 3: Put temp elements at the end
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array: ");
        for (int num : arr) System.out.print(num + " ");

        rotatearray(arr, 2);
        System.out.println("\nArray after rotating by 2 positions: ");
        for (int num : arr) System.out.print(num + " ");
    }
}

