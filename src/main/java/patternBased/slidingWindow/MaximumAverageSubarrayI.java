package patternBased.slidingWindow;
// 643. Maximum Average Subarray I

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and
 * return this value. Any answer with a calculation error less than 10-5 will be accepted.
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        //double maxAvg = -Double.MAX_VALUE;
        //double maxAvg = Double.MIN; //most negative number which we don't want
        if(nums == null || nums.length == 0){
            return 0.0;
        }
        int windowSum = 0;
        //Step1: Calculate sum of first k elements
        for(int i = 0; i<k; i++){
            windowSum += nums[i];
        }
        int maxSum = windowSum;
        //Step 2: Slide the window
        for(int i = k; i<nums.length; i++){
            windowSum += nums[i]; //add right element
            windowSum -= nums[i-k]; //remove left element
            maxSum = Math.max(maxSum, windowSum);
        }
        return (double) maxSum/k;
    }
}
//Note- Sliding Window means “Subtract element leaving the window, add element entering the window”
//TC = O(n)
//SC = O(1)

/**
 * Dry Run-
 * nums = [1,12,-5,-6,50,3], k = 4
 *
 * First window sum = 1+12-5-6 = 2
 *
 * i=4 → add 50, remove 1 → sum = 51
 * i=5 → add 3, remove 12 → sum = 42
 *
 * maxSum = 51
 * avg = 51 / 4 = 12.75
 */

