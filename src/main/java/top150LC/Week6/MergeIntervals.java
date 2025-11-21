package top150LC.Week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Why we use the Comparator?
 * intervals is a 2D array (int[][]).
 * The default Arrays.sort() without a comparator doesn’t know how to compare two subarrays (int[]).
 * Each element of intervals is itself an int[] (like [1,3] or [2,6]), not a simple integer or string.
 * So you must tell Java “how to compare two subarrays”, i.e., on what basis to sort them.
 * That’s what the comparator does:
 * It says — when comparing two intervals a and b, compare their start times (a[0] vs b[0]).
 * If you try to use:
 * Arrays.sort(intervals);
 * you’ll get a ClassCastException or unexpected results, because Java doesn’t have a natural ordering for int[].
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        //Step1:
        //Using Comparator
        //It’s like sorting a list of pairs — you must tell Java which field to use for comparison.
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));

        //Step2:
        List<int[]> output = new ArrayList<>();// as actual size of output is not known.
        int[] currInt = intervals[0];
        output.add(currInt);

        for(int[] interval: intervals){
            int begin = currInt[0];
            int end = currInt[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            //Case 1: Overlap (end >= nextBegin)
            //You merge intervals — update the same array object that’s already in output.
            //So no need to add anything new — you just extend its end value.
            if(end >= nextBegin){
                currInt[1] = Math.max(end, nextEnd);
            }
            //Case 2: No overlap (end < nextBegin)
            //You’re done with the current interval (currInt).
            //You need to start a new merged interval.
            else {
                currInt = interval; //Now start merging from this new interval.
                output.add(currInt); //Add this as a separate merged range.
            }
        }
        return output.toArray(new int[output.size()][]);//converting list to Array [][]
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
