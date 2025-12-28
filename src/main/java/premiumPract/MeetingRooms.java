package premiumPract;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));//sort by start time

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
