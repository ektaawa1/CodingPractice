package patternBased.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 * Input: heights = [4,2,3,1]
 * Output: [0,2,3]
 * Input: heights = [4,3,2,1]
 * Output: [0,1,2,3]
 * Input: heights = [1,3,2,4]
 * Output: [3]
 */
public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        //ocean view possible when right side values are smaller than the current values
        //Traverse from right to left
        //return the index of those ocean view buildings, in ascending order
        List<Integer> indexes = new ArrayList<>();//We don't know the result size so using list
        int maxHeight = 0;
        for(int i = heights.length-1; i>=0; i--){
            if(heights[i] > maxHeight){
                indexes.add(i);
                maxHeight = heights[i];
            }
        }
        //indexes in asc order
        Collections.reverse(indexes);

        //Construct the result by converting it to array
        int ans[] = new int[indexes.size()];
        for(int i  =0; i< indexes.size(); i++){
            ans[i]= indexes.get(i);
        }
        return ans;
    }
    //Using Stack if asked further by the interviewer
    public int[] findBuildings1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        //Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() &&
                    heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }

            stack.push(i);
        }

        int[] result = new int[stack.size()];
        int idx = stack.size() - 1;

        while (!stack.isEmpty()) {
            result[idx--] = stack.pop();
        }

        return result;
    }
}

/**
 Start from rightmost building
 Track maxSoFar
 If heights[i] > maxSoFar → add index
 Update max
 Reverse result (since we scanned backwards) */

//What if the demand is ocean view from both the sides??
//No taller/equal building on the LEFT
//No taller/equal building on the RIGHT
//This means the building is a peak relative to entire array.
