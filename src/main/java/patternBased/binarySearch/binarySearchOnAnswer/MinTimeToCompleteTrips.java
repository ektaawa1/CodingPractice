package patternBased.binarySearch.binarySearchOnAnswer;
//2187. Minimum Time to Complete Trips ??????Try understanding it again??????????

/**
 * Input: time = [1,2,3], totalTrips = 5
 * Output: 3
 *
 * Input: time = [2], totalTrips = 1
 * Output: 2
 */
public class MinTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        //i.e., tripCount >= totalTrips
        // min time means first True
        // BS on answer

        int minTime = Integer.MAX_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }
        long low = 1; //lowest time
        long high = (long) minTime * totalTrips;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (canFinish(time, totalTrips, mid)) {
                high = mid;        // first true
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canFinish(int[] time, int totalTrips, long T) {
        long trips = 0;

        for (int t : time) {
            trips += T / t;
            if (trips >= totalTrips) return true;
        }

        return false;
    }
}
