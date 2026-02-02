package patternBased.slidingWIndow;
// 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

/**
 * Given an array of integers arr and two integers k and threshold,
 * return the number of sub-arrays of size k and average greater than
 * or equal to threshold.
 */
public class SubArrKSizeAndAvgGreaterThanT {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        //window size = k
        int left = 0;
        int windowSum = 0;
        int count = 0;
        //Step1: Create a window of size K
        for(int i = 0; i<k; i++){
            windowSum += arr[i];
        }
        if(windowSum/k >= threshold){
            count++;
        }
        //Step2: Slide Window
        for(int right = k; right<arr.length; right++){
            windowSum += arr[right];//add one element from right
            windowSum -= arr[right-k];// remove one element from left

            if(windowSum/k >= threshold){
                count++;
            }
        }
        return count;
    }
}
/**
 Fixed Sliding Window RULE:
 1) Precompute first window
 2) Loop from k → n-1
 3) Add right, remove right-k
 4) Check condition
 */

/**
 * Example-
 * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * Output: 3
 * Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
 * All other sub-arrays of size 3 have averages less than 4 (the threshold).
 *
 * Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * Output: 6
 * Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 */

