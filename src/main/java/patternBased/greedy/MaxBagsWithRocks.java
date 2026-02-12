package patternBased.greedy;
// 2279. Maximum Bags With Full Capacity of Rocks

import java.util.Arrays;

/**
 * Return the maximum number of bags that could have full capacity
 * after placing the additional rocks in some bags.
 * Input: capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
 * Output: 3
 */
public class MaxBagsWithRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // find the maximum no of bags which means find last True but here BS is not needed
        //capacity[i] is max capacity of bag i
        // rocks[i] is current number of rocks in bag i
        // rocks needed to fill the bag = capacity[i] - rocks[i];
        int n = capacity.length;
        int needed[] = new int[n];

        for(int i = 0; i<n; i++){
            needed[i] = capacity[i] - rocks[i];
        }
        //Sort the array so we can fill the easiest bags first
        Arrays.sort(needed);

        //greedily fill untill we run out of extra rocks
        int fullBagsCount = 0;
        for(int need : needed){
            if(additionalRocks >= need){
                additionalRocks -= need;
                fullBagsCount++;
            } else {
                break;
            }
        }
        return fullBagsCount;
    }
}
// TC = O(n log n)

/**
 * Explanation-
 * Input: capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2, Output: 3
 * Bag 0: capacity 2, currently has 1 rock → needs 1 more to be full
 * Bag 1: capacity 3, currently has 2 rocks → needs 1 more to be full
 * Bag 2: capacity 4, currently has 4 rocks → already full
 * Bag 3: capacity 5, currently has 4 rocks → needs 1 more to be full
 */
