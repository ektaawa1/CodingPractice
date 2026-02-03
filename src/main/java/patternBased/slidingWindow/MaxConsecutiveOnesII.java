package patternBased.slidingWindow;
// 487. Max Consecutive Ones II

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array
 * if you can flip at most one 0.
 * Example-
 * Input: nums = [1,0,1,1,0], Output: 4
 *
 * Input: nums = [1,0,1,1,0,1], Output: 4
 */
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int maxLen = 0;
        int countZero = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                countZero++;
            }

            while (countZero > 1) {
                if (nums[left] == 0) {
                    countZero--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
