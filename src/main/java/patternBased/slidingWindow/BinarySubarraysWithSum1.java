package patternBased.slidingWindow;
// 930. Binary Subarrays With Sum

import java.util.HashMap;

/**
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 * A subarray is a contiguous part of the array.
 * nums[i] is either 0 or 1.
 * Core Pattern identity:
 * Exactly(K) = AtMost(K) − AtMost(K − 1)
 */
public class BinarySubarraysWithSum1 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private int atMost(int[] nums, int k) {
        if (k < 0) return 0;   // important edge case

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            // All subarrays ending at right with sum ≤ k
            count += right - left + 1;
        }

        return count;
    }
}

/**
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 */
/**
 * Key Trick
 * Count subarrays with sum ≤ goal
 * Count subarrays with sum ≤ goal − 1
 * Subtract ---> exact(goal) = atMost(goal) − atMost(goal − 1)
 * Why this works?
 * Because array contains only 0s and 1s (non-negative)
 * → window sum changes monotonically.
 *
 *
 * Why count += right - left + 1 ?
 * This is the magic part ⭐
 * At index right, once window [left…right] satisfies sum ≤ k:
 * Every subarray ending at right and starting anywhere from left to right is valid.
 */