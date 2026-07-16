
public class largestarray {
     public static int largest(int numbers[]) {
         
         int max = Integer.MIN_VALUE;
         for(int i=0; i<numbers.length; i++) {
             if(numbers[i] > max) {
                 max = numbers[i];
             }
         }
         return max;
     }
     public static int smallest(int numbers[]) {
         int min = Integer.MAX_VALUE;
         for(int i=0; i<numbers.length; i++) {
             if(numbers[i] < min) {
                 min = numbers[i];
             }
         }
         return min;
     }
    public static void main(String args[]) {
        int numbers[] = {11, 2, 9, 49, 5};
        System.out.println("Largest number is: " + largest(numbers));
        System.out.println("Smallest number is: " + smallest(numbers));
    }}