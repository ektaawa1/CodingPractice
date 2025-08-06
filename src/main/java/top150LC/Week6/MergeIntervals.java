package top150LC.Week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        //using comparator
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        List<int[]> output_list = new ArrayList<>();// as actual size of output is not known.
        int curr_interval[] = intervals[0];
        output_list.add(curr_interval);

        for(int[] interval: intervals){
            int curr_begin = curr_interval[0];
            int curr_end = curr_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if(curr_end >= next_begin){
                curr_interval[1] = Math.max(curr_end, next_end);
            }else {
                curr_interval = interval;
                output_list.add(curr_interval);
            }
        }
        return output_list.toArray(new int[output_list.size()][]);//converting list to Array
    }
}

//Time: O(n log n) → because of sorting
//Space: O(n) → for storing the result list

/**
 * What if the intervals are stored in a LinkedList instead of an array?
 * Answer:
 * Since LinkedLists don’t support random access, sorting is less efficient.
 * I'd either convert it to an array, sort and merge, or implement merge sort directly on the linked list.
 *
 * Can you merge intervals in-place to reduce space?
 * Answer:
 * Yes. Instead of using a separate result list, we can overwrite the input array and use a pointer to track the position of merged intervals.
 * However, this makes the logic more complex and slightly harder to maintain.
 */
