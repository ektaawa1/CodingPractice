package top75LC.Week2;

/**
 * Example 1:
 *
 * Input: gain = [-5,1,5,0,-7]
 * Output: 1
 * Explanation: 0, 0+(-5), -5+1, -4+5, 1+0, 1+(-7)
 * The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
 */
public class HighestAltitude {
    public int largestAltitude(int[] gain) {
        int currAltitude = 0;
        int maxAltitude = 0;
        for(int g : gain){
            currAltitude += g;
            maxAltitude = Math.max(currAltitude, maxAltitude);
        }
        return maxAltitude;
    }
}
//Time: O(n)
//Space: O(1)
