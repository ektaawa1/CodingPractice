package patternBased.binarySearch.binarySearchOnAnswer;
//1552. Magnetic Force Between Two Balls

import java.util.Arrays;

/**
 * Morty has m balls and needs to distribute the balls into the baskets
 * such that the minimum magnetic force between any two balls is maximum.
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 * Given the integer array position and the integer m. Return the required force.
 *
 * Input: position = [5,4,3,2,1,1000000000], m = 2
 * Output: 999999999
 * Explanation: We can use baskets 1 and 1000000000.
 *
 * Input: position = [1,2,3,4,7], m = 3
 * Output: 3
 * Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
 */
public class MagneticForceBwtTwoBalls {
    public int maxDistance(int[] position, int m) {
        // min magnetic force is maximum i.e. Last True
        //position of baskets is given
        // m is the number of balls

        //Note: Always sort for distance problems.

        Arrays.sort(position);
        int len = position.length-1;
        int low = 1;
        int high = position[len] - position[0];

        //Why?? This pattern is for maximization (last true). We must test every candidate distance, including when low == high.
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canDistribute(position, m, mid)){
                low = mid+1; // try bigger distance
            }else {
                high = mid-1;
            }
        }
        return high; //Last Truw
    }
    private boolean canDistribute(int[] position, int m, int minFreq){
        int count = 1; //why 1??
        int last = position[0];

        for(int i = 0; i<position.length; i++){
            if(position[i]-last >= minFreq){
                count++;
                last = position[i];
            }
        }
        return count >= m; //If we can place at least m balls, then distance d is feasible.
    }
}

/**
 We place balls greedily:
 First ball at pos[0]
 Next ball must be at least d away
 So we place a ball only if:
 current_position − last_placed_position ≥ d
 */
