package patternBased.twoPointers;

import java.util.Arrays;
//premium question
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
//2 pointers approach
public class MinPlatformsRequired {
    //same as meeting rooms II
    public int findPlatform(int[] arrival, int[] dep) {
        Arrays.sort(arrival);//[935, 1000, 1100]
        Arrays.sort(dep);//[1130, 1200, 1240]
        int i = 0, j = 0;
        int platforms = 0, maxPlatforms = 0;

        while(i< arrival.length){
            if(arrival[i]<dep[j]){ //Arrival comes first → means overlappin so need a new platform
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
/**
 * It means:
 * What is the maximum number of trains present at the station at the same time?
 * Because that maximum overlap determines minimum platforms required.
 * At any time:
 * If 1 train → 1 platform
 * If 2 trains overlapping → 2 platforms
 * If 3 overlapping → 3 platforms
 */