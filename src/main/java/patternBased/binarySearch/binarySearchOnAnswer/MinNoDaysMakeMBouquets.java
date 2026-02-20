package patternBased.binarySearch.binarySearchOnAnswer;
// 1482. Minimum Number of Days to Make m Bouquets

/**
 *Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
 * If it is impossible to make m bouquets return -1.
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * Output: 3
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
 * Output: -1
 * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * Output: 12
 */
public class MinNoDaysMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        // firstTrue
        // BS on answer i.e. days

        if((long)m*k > bloomDay.length){ //Use long to avoid overflow
            return -1;
        }

        int low = 1;
        int high = 0;

        for(int n : bloomDay){
            high = Math.max(n, high);
        }

        while(low < high){
            int mid = low + (high-low)/2; //finding mid day
            if(makeBouquet(bloomDay, m, k, mid)){ //Can we make m bouquets on day mid?
                high = mid; // day works, try smaller i.e., on the left side
            } else {
                low = mid + 1; // day too small, need bigger
            }
        }
        return low; // first day that works
    }

    private boolean makeBouquet(int[] bloomDay, int m, int k, int day){
        int flowerCount = 0;
        int bouquetCount = 0;
        for(int bloomD : bloomDay){
            if(bloomD <= day){
                flowerCount++; // count consecutive bloomed flowers
                if(flowerCount == k){
                    bouquetCount++;
                    flowerCount = 0; //resetting it for another bouquet making
                }
            } else {
                flowerCount = 0;
            }
        }
        return bouquetCount >= m;
    }
}
/**
 Given:
 bloomDay[i] → day the ith flower blooms
 You want m bouquets
 Each bouquet needs k adjacent flowers

 We need m*k flowers in total
 If m * k > n, return -1.

 TC on Binary search over range [1, D] takes:
 O(log D) where D = max(bloomDay)
 Now, TC of makeBouquet() function is= O(n) as you are scanning all the n numbers

 So, Final TC = O(n log D) i.e. O(n) * O(log D)
 where n = number of flowers, D = max bloom day value
 SC = O(1)
 */

