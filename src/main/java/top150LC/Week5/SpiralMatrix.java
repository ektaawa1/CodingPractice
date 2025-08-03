package org.Week5;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> output = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0; int right = matrix[0].length-1;
        if(matrix.length == 0 || matrix == null){
            return output;
        }

        while(top <= bottom && left <= right){
            //left to right
            for(int i = left; i<= right; i++){
                output.add(matrix[top][i]);
            }
            top++;
            //top to bottom
            for(int i = top; i<= bottom; i++){
                output.add(matrix[i][right]);
            }
            right--;
            //right to left
            if(top <= bottom){ // prevents Traversing the same row twice or invalid row
                for(int i = right; i>= left; i--){
                    output.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //bottom to top
            if(left <= right){ // prevents Traversing invalid column or duplication
                for(int i = bottom; i>= top; i--){
                    output.add(matrix[i][left]);
                }
                left++;
            }
        }
        return output;
    }
}
/**
 * TC is O(m × n) where m = rows and n = columns.
 * That’s the best possible because we visit each element once.
 */
