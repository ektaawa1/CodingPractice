package premiumPract;

import java.util.Arrays;

/**
 * You are given:
 * Arrival times of trains, Departure times of trains
 *
 * You need:
 * Minimum number of platforms so no train waits
 *
 * Example- Input: arrival[] = [1000, 935, 1100],
 * dep[] = [1200, 1240, 1130]
 * Output: 3
 */
public class MinPlatformsRequired {
    //same as meeting rooms II
    public int findPlatform(int[] arrival, int[] dep) {
        Arrays.sort(arrival);
        Arrays.sort(dep);
        int i = 0, j = 0;
        int platforms = 0, maxPlatforms = 0;

        while(i< arrival.length){
            if(arrival[i]<dep[j]){ //Arrival comes first → need a new platform
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else{ //Departure comes first → free a platform
                platforms--;
                j++;
            }
        }
        return maxPlatforms;
    }
}
