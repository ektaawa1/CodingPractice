package patternBased.slidingWindow;
//209. Minimum Size Subarray Sum

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class MinSizeSubArraySum {
    //Variable size sliding window approach, 2 pointers
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for(int right = 0; right<nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                minLen = Math.min(minLen, right-left+1);
                //now shrink the window to see if that also meets the while condition
                sum = sum - nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    //prefer this one
    public int minSubArrayLen1(int target, int[] nums) {
        int left = 0;
        int minLen = nums.length + 1; // Slightly more than max possible
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
/**
 * Are you working with a contiguous sequence (subarray or substring)?
 *
 * Do you need to find the minimum / maximum length of such a sequence that meets a sum, frequency, or pattern?
 *
 * Do you want to expand the window to include elements until a condition is met, and shrink it to optimize something?
 *
 * If yes → It's sliding window (variable size)!
 */
