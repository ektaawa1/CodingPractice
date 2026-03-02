package premiumPract;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals where
 * intervals[i] = [start_i, end_i],
 * determine if a person can attend all meetings.
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Input: [[7,10],[2,4]]
 * Output: true
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }
        //sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //or Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 1; i<intervals.length; i++){//check overlap
            if(intervals[i][0] < intervals[i-1][1]){//5<30 ==> overlapping so false
                return false;
            }
        }
        return true;
    }
}
//sort the meeting by start time.
//then compare each meeting time with the previous one.
//Time: O(n log n) (sorting)
//Space: O(1) extra (sorting in-place)
