package patternBased.slidingWIndow;
// 1004. Max Consecutive Ones III

/**
 * Given a binary array nums and an integer k,
 * return the maximum number of consecutive 1's in the array
 * if you can flip at most k 0's.
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        // count consecutive 1s
        // can flip k 0s which means
        // You only COUNT how many 0s are inside the window
        int zeroCount = 0;
        int maxLen = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            //shrink the window if invalid
            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left +1);
        }
        return maxLen;
    }
}

//TC = O(n), SC = O(1)
/**
 * Example-
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */