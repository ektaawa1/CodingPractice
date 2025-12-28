package premiumPract;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int[] startArr = new int[intervals.length];
        int[] endArr = new int[intervals.length];

        for(int i = 0; i<intervals.length; i++){
            startArr[i] = intervals[i][0];
            endArr[i] = intervals[i][1];
        }

        Arrays.sort(startArr);//0,5,15
        Arrays.sort(endArr);//10,20,30

        int i=0, j=0;
        int rooms = 0, maxRooms = 0;
        while(i < intervals.length){
            if(startArr[i] < endArr[j]){ //A new meeting starts before the earliest ongoing meeting ends
                //so we need a new room
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                i++;
            }else{ //A meeting has ended before or exactly when the next one starts
                rooms--; //A room is freed, We can reuse it
                j++;
            }
        }
        return maxRooms;
    }
    //minHeap Solution
    public int minMeetingRooms1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //[[0,30],[5,10],[15,20]]

        // Step 2: Min heap to track end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first meeting end time
        minHeap.offer(intervals[0][1]);//30

        // Step 3: Process remaining meetings
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];//5,15
            int end = intervals[i][1];//10,20

            // If room is free, reuse it
            if (start >= minHeap.peek()) {//15> 10
                minHeap.poll(); //[30] is left in minHeap
            }

            // Add current meeting
            minHeap.offer(end);//10,20 but 10 got removed befor
        }

        return minHeap.size();// 2 as 20,30 is left in the minHeap
    }
}
/**
 * | Approach     | TC           | SC     |
 * | ------------ | ------------ | ------ |
 * | Min Heap     | `O(n log n)` | `O(n)` |
 * | Two Pointers | `O(n log n)` | `O(n)` |
 */
