// Given an array, and an element num the task is to find if num is present in the given array or not. 
// If present print the index of the element or print -1.
public class linearSearch {
    public static int search(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
}
public static void main(String[] args) {
        int[] arr = {6,28,9,2,30,15};
        int num = 2;
        int result = search(arr, num);
        if (result == -1){
            System.out.println("Element not found in the array");
        }
        else{
            System.out.println("Element found at index: " + result);
        } 
        }
}
