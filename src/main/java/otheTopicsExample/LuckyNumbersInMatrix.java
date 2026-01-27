package otheTopicsExample;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> minRowList = new ArrayList<>();
        List<Integer> maxColList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        //Find each row's min element
        for(int i = 0; i< rows; i++){
            int minVal = Integer.MAX_VALUE;
            for(int j = 0; j<cols; j++){
                minVal = Math.min(minVal,matrix[i][j]);
            }
            minRowList.add(minVal);
        }

        //Find each column's max element
        for(int j = 0; j<cols; j++){
            int maxVal = Integer.MIN_VALUE;
            for(int i = 0; i< rows; i++){
                maxVal = Math.max(maxVal, matrix[i][j]);
            }
            maxColList.add(maxVal);
        }
        //Print the common from both the lists
        for(int num : minRowList){
            if(maxColList.contains(num)){
                result.add(num);
            }
        }
        return result;
    }
}
/**
 * Time Complexity:
 * Row mins → O(m * n)
 * Column maxs → O(m * n)
 * Compare lists → O(m * n) in worst case
 * So overall → O(m * n), which is fine for small matrices.
 * Instead of using List.contains (O(n)), use a HashSet for column maxs:
 * This reduces lookup to O(1), making overall time O(m * n) but slightly faster in practice.
 */
