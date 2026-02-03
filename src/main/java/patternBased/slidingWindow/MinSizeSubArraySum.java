package patternBased.slidingWindow;

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
