//find Second Largest Element in Array
public class secondlargest {
    public static int getsecondLargest(int numbers[]){
        int Slargest = Integer.MIN_VALUE;
        int Largest = Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] > Largest) {
                Slargest = Largest;
                Largest = numbers[i];
            } else if(numbers[i] > Slargest && numbers[i] != Largest) {
                Slargest = numbers[i];
            }
        }
        return Slargest;
    }
    public static void main(String args[]){
        int numbers[] = {7,2,19,5,44,19};
        System.out.println("Second Largest number is: " + getsecondLargest(numbers));
        System.out.println("Largest number is: " + largestarray.largest(numbers));
    }
}