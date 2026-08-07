import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> SpiralTraversalMatrix (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;   //rows
        int m = matrix[0].length;   //columns
        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;
// Loop until all elements are traversed
        while (top <= bottom && left <= right) {

        for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
        }
        top++;
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
            right--;
        // Traverse the bottom row from right to left (ONLY if top hasn't crossed bottom)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary upward
            }

            // Traverse the left column from bottom to top (ONLY if left hasn't crossed right)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightward
            }
        }
    return result;
    }
public static void main(String[] args) {
        int [][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        SpiralOrder obj = new SpiralOrder();
        List<Integer> result = obj.SpiralTraversalMatrix(matrix);
        System.out.println(result);
    }
}
        