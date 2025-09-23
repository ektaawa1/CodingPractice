package top150LC.Week8;

import java.util.ArrayList;
import java.util.List;

class Interval{
    int start;
    int end;
    Interval(int s, int e){
        start = s;
        end = e;
    }
}

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        //Step1: add all smaller intervals before new interval
        while(i<n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        //Step2: merge overlapping intervals with new interval
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        //Step3: add the rest of the intervals
        while(i<n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
    public int[][] insertA(int[][] intervals, int[] newInterval) {
        List<int[]> before = new ArrayList<>();
        List<int[]> after = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] interval : intervals) {
            if (interval[1] < start) {
                before.add(interval);
            } else if (interval[0] > end) {
                after.add(interval);
            } else {
                // merge overlap
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }

        List<int[]> result = new ArrayList<>(before);
        result.add(new int[]{start, end});
        result.addAll(after);

        return result.toArray(new int[result.size()][]);
    }

    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval); // before newInterval
            } else if (interval.start > newInterval.end) {
                result.add(newInterval); // insert once
                newInterval = interval; // continue with rest
            } else {
                // overlap: merge
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }

        result.add(newInterval); // add the last one
        return result;
    }
}

// 1  2  3  5  6  7  8  10  12  16
// ----  ----  ----  -----   ----
//         -----------
// ----   ---------------    ----     output

/**
 Time: O(n) → each interval is visited once.

 Space: O(n) for result storage. */

