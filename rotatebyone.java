public class rotatebyone {
    public static void rotatearray(int[] arr) {
        int temp = arr[0];  // 1. Save the first element temporarily, as it will be overwritten.
        if (arr == null || arr.length <= 1) { //edge case: if the array is null or has only one element, no rotation is needed
            return;
        }

         // 2. Shift all remaining elements one position to the left.
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        } //After loop, the array looks like [2, 3, 4, 5, 5] for input [1, 2, 3, 4, 5]. The last element is still wrong (duplicated), which is fixed in the next step.
           // Place the saved first element at the very end of the array.
        arr[arr.length - 1] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
          rotatearray(arr);
// Output the rotated array
        // Expected output: [2, 3, 4, 5, 1]
            System.out.println();
        System.out.println("Array after rotating by one position: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }}
