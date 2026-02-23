package patternBased.binarySearch.binarySearchOnAnswer;

/**
 * Given an integer array nums and an integer k, split nums into k non-empty
 * subarrays such that the largest sum of any subarray is minimized.
 * Return the minimized largest sum of the split.
 * A subarray is a contiguous part of the array.
 *
 * Input: nums = [7,2,5,10,8], k = 2
 * Output: 18
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest sum
 * among the two subarrays is only 18.
 *
 * Input: nums = [1,2,3,4,5], k = 2
 * Output: 9
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        //minimized largest sum means-
        //First True
        // BS on answer so low should be min sum value & high should be max sum value
        //low = max(nums)
        //high = max(sum) which is adding all the nums

        int low = 0;
        int high = 0;
        for(int num : nums){
            low = Math.max(num, low);
            high += num;
        }
        while(low<high){
            int mid = low + (high-low)/2;

            if(canSplit(nums, k, mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canSplit(int[] nums, int k, int maxSum){
        int sum = 0;
        int count = 1; //why 1??
        //Because even if we never split, the whole array itself is one subarray.
        //Before processing anything → we already have 1 current subarray.

        for(int n : nums){
            sum += n;
            if(sum > maxSum){//As we keep adding numbers to the current subarray, If it becomes too big-> We MUST start a new subarray
                count++;
                sum = n; // Because the current number still needs to be included — just in a new subarray.
            }
        }
        return count <= k;
    }
}
