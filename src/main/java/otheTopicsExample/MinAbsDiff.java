package otheTopicsExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 1:
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 *
 * Example 2:
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 *
 * Example 3:
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 */
public class MinAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i<arr.length; i++){
            minDiff = Math.min(minDiff, arr[i]-arr[i-1]);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i = 1; i< arr.length; i++){
            if(arr[i]-arr[i-1] == minDiff){
                resultList.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return resultList;
    }
}
//TC = O(nlogn)
