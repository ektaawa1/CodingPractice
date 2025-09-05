package top150LC.Week6;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowFlag = false; //Two flags keep track if first row or first column
        // should be fully zeroed at the end
        boolean firstColFlag = false;

        // when 0 is present in 0th row, set row flag to true
        // Check first row for any zero.
        //If found, set firstRowFlag = true.
        //Why? Because later we’ll overwrite matrix[0][j] as markers, so we need to remember separately if the whole row should be zero.
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowFlag = true;
            }
        }

        // when 0 is present in 0th column, set column flag to true
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColFlag = true;
            }
        }

        //Now checking in other rows & columns if 0 is present or not
        // If present then setting the 0th row & 0th column to 0
        // excluding 0th row & col
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row (row marker)
                    matrix[0][j] = 0; // mark col (column marker)
                }
            }
        }

        // Now setting the entire row & column to 0
        // from index 1 till rows & columns
        // where 0th row & 0th column is set to 0
        // If row marker matrix[i][0] is 0 OR column marker matrix[0][j] is 0, set cell (i,j) to 0.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // if row flag is true then set the entire 0th row to 0
        if (firstRowFlag) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // if column flag is true then set the entire 0th column to 0
        if (firstColFlag) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

//TC = O(m*n)
//SC = O(1)
