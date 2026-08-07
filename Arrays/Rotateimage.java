import java.util.Arrays;
public class Rotateimage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for( int i = 0; i <n; i++){
            for(int j  = i+1; j<n; j++){
                swap(matrix, i, j);
            }
        }
        for(int i = 0; i<n; i++){
            reverse(matrix[i]);         // pass the row (a 1D int[]) to the helper
        }
    }
    public void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    public void reverse(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
}

    public static void main(String[] args) {
        Rotateimage obj = new Rotateimage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        obj.rotate(matrix);
            for(int[] row : matrix){
                System.out.println(Arrays.toString(row));
            }
        }}