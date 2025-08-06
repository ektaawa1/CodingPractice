package top150LC.Week6;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;

        // Step 1: Transpose
        for(int i = 0; i<size; i++){
            for(int j = i+1; j<size; j++){
                // Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Step 2: Reverse each row
        for (int i = 0; i<size; i++){
            reverse(matrix[i]);
        }
    }
    private void reverse(int row[]){
        int left = 0;
        int right = row.length-1;

        while(left<right){
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
    // for counterclockwise- transpose & then reverse columns
    public void rotateCounterClockwise(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each column
        for (int j = 0; j < n; j++) {
            int top = 0, bottom = n - 1;
            while (top < bottom) {
                int temp = matrix[top][j];
                matrix[top][j] = matrix[bottom][j];
                matrix[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
    }
}
//Time Complexity: O(n^2)
//Space Complexity: O(1) → in-place

/**
 * To rotate the matrix 90 degrees clockwise in-place,
 * I transpose it to swap rows with columns, and then mirror each row to simulate the rotation.
 */
