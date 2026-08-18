
public class NextPermutation {
    public void getNextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        // If no index found
        if (index == -1) {
            // Reverse the entire array
        reverse(arr, 0, arr.length - 1);  //Call reverse(...) to reverse the whole array (0 to last index) — this gives the smallest arrangement.
            return;
        }

        // Find just larger element
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                swap(arr, i, index);
                break;
            }
            }
            // Step 3: reverse everything after index
        reverse(arr, index + 1, n - 1);
        }
        private void reverse (int [] arr, int start, int end){
            while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
 private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     public static void main(String[] args) {
        int[] arr = {1, 5, 8, 4, 7, 6, 5, 3, 1};
/*Since getNextPermutation is not static (no static keyword on it), you can't call it directly from main.
 You first need to create an object/instance of the class using new NextPermutation(), storing it in variable obj */
       NextPermutation obj = new NextPermutation();
       
    /*Calls the method on our object, passing in arr. Since Java arrays are passed by reference, any in-place changes made 
    inside getNextPermutation are reflected in this same arr variable here — that's why the method doesn't need to return anything. */   
    obj.getNextPermutation(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }  
}
