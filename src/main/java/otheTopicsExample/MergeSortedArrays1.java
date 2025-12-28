package otheTopicsExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Input: mat[][] = [
 * [1, 3, 5, 7],
 * [2, 4, 6, 8],
 * [0, 9, 10, 11]
 * ]
 * Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 */
//Min Heap (PriorityQueue) – K-way Merge

public class MergeSortedArrays1 {
    //flatten + sort, TC= O(N log N)
    public List<Integer> mergeSortedArrays(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        for (int[] row : mat)
            for (int num : row)
                result.add(num);

        Collections.sort(result);
        return result;
    }
    //optimized solution O(n log k)
    public List<Integer> mergeSortedArrays1(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        // Step 1: push first element of each row i.e., 1,2,0
        for(int i = 0; i<mat.length; i++){
            minHeap.offer(new int[]{mat[i][0],i,0});//{value, row, col}
        }
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();// 0,0,0
            int val = curr[0];
            int row = curr[1];
            int col = curr[2];

            result.add(val);//0
            //now insert the next element from the same list i.e, 9
            if(col+1 < mat[row].length){//boundary condition: Does this row still have another element after this one?
                minHeap.offer(new int[]{mat[row][col+1], row, col+1});
            }
        }
        return result;
    }
}

/**
 * Time: O(N log K), N = total elements, K = number of rows
 * Space: O(K) (heap)
 * This is much better than flatten + sort (O(N log N)).
 * Since each row is already sorted, I use a min heap to do a K-way merge.
 * I push the first element of each row, then repeatedly extract the minimum and
 * insert the next element from the same row. This gives O(N log K) time.
 */
