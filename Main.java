/* public class sorted {
    public static boolean issorted(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int num[] = {1, 90, 3, 4, 5};
        System.out.println(issorted(num));
    }
} */
class Solution {
    // Function to check if the array is sorted
    public boolean isSorted(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // If any element is smaller than the previous one, return false
                if (arr[j] < arr[i]) 
                    return false;
            }
        }
        return true; // Return true if no unsorted elements are found
    }
}

