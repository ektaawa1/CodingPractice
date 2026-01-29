package patternBased.slidingWIndow;
// 485. Max Consecutive Ones

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                left = right+1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
