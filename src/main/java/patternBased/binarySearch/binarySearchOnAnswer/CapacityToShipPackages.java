package patternBased.binarySearch.binarySearchOnAnswer;
// 1011. Capacity To Ship Packages Within D Days

/**
 * Return the least weight capacity of the ship that will result in all the packages
 * on the conveyor belt being shipped within days days.
 *
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5, Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7   3rd day: 8   4th day: 9   and   5th day: 10
 *
 * Input: weights = [3,2,2,4,1,4], days = 3,  Output: 6
 * Input: weights = [1,2,3,1,1], days = 4,    Output: 3
 */
public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        // split the weights sum acc to days
        // find the least weight capacity (i.e., 1st TRUE)
        // binary search on answer i.e. capacity
        // what is min capacity? max weights[i] i.e., 10
        // what is max capacity? sum of weights[i] i.e., 55

        //Simulate greedily: Start day = 1, Keep adding weights, If overflow → new day, If days > D → return false
        int low = 0;
        int high = 0;
        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }

        while(low < high){
            int midCapacity = low + (high-low)/2;
            if(canShip(weights, days, midCapacity)){
                high = midCapacity;
            } else {
                low = midCapacity + 1;
            }
        }
        return low;
    }
    private boolean canShip(int[] weights, int days, int capacity){
        int daysNeeded = 1;
        int sum = 0;

        for(int weight : weights){
            //sum += weight;
            if(sum+weight > capacity){ //overflow
                daysNeeded++;
                sum = 0; //start new day
            }
            sum += weight; //add curr weight to new day
        }
        return daysNeeded <= days;
    }
}
// Time complexity is O(n * log S) where n = number of weights and S = sum of weights
//log S because each binary search step halves the range of possible capacity



// Ask these questions to yourself
/**
 If I increase the capacity, does the problem become easier?????
 If capacity is small → need more days
 If capacity is big → fewer days
 That means the answer space is monotonic.
 Example:
 Capacity --> Days
 11 -->1+2+3+4, 5+6, 7, 8, 9, 10 i.e., 6 days which means increase capacity (F)
 12--->                                                                     (F)
 13-->                                                                      (F)
 14--->                                                                     (F)
 15---> 1+2+3+4+5, 6+7, 8, 9, 10 i.e., 5 days (T) (First True)
 20 ---> 1+2+3+4+5, 6+7, 8+9, 10 i.e., 4 days (T)
 25 --->                                      (T)
 */
//Are we finding FIRST valid or LAST valid?
//Because most binary search on answer problems reduce to this exact structure:
//You’re searching a range of possible answers.
//And for every possible answer x, the condition is either:
//False  False  False  True  True  True  (We want 1st TRUE)
//OR
//True  True  True  False  False  False (We want last TRUE)
