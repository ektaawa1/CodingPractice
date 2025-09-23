package top150LC.Week7;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = (rows*cols) -1;

        while(left <= right){
            int mid = left + (right-left)/2;
            int r = mid/cols;
            int c = mid%cols;

            int midVal = matrix[r][c];
            if(midVal == target){
                return true;
            }else if(midVal < target){
                left = mid +1;
            }else {
                right = mid-1;
            }
        }
        return false;
    }
}
/**
 Since the matrix is sorted row-wise and column-wise as per condition,
 we can just binary search directly between 0 and m*n - 1. */
//Treat as Flattened 1D Array
//Convert 1D index → 2D indices:
//row = mid // n
//col = mid % n
//Compare matrix[row][col] with target.
/**
 Time Complexity:O(log(mn))
 Space: O(1) */

/**
 * Dry Run Example
 * matrix = [
 *   [1, 3, 5, 7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 60]
 * ]
 * target = 16
 * m=3, n=4 → total elements = 12 (indices 0..11)
 * left=0, right=11
 * mid=5 → row=5/4=1, col=5%4=1 → matrix[1][1]=11 → < target → move right
 * mid=8 → row=2,col=0 → matrix[2][0]=23 → > target → move left
 * mid=7 → row=1,col=3 → matrix[1][3]=20 → > target → move left
 * mid=6 → row=1,col=2 → matrix[1][2]=16 ✅ found
 */
