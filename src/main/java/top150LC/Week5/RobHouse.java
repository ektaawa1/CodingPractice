package org.Week5;

/**
 * Why Dynamic Programming?
 * Because each decision (rob or skip) depends on previous decisions, and
 * there’s overlapping subproblems. That’s what DP is good at!
 */

/**
 * Step-by-step Intuition:
 * Let’s say you are at index i. You have 2 choices:
 * Rob house i
 * → You must skip house i-1, so total = nums[i] + dp[i-2]
 * Skip house i
 * → You can take whatever was max till i-1, so total = dp[i-1]
 * Now, take the max of the two:
 * dp[i] = max(dp[i-1], nums[i] + dp[i-2])
 */

/**
 * prev2 holds the max amount if we skip the current house and go back two.
 * prev1 holds the max amount until the previous house.
 * curr is the max money we can have at the current house.
 */
public class RobHouse {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }
    public int rob1(int[] nums){
        int prev1 = 0;//dp[i-1]
        int prev2 = 0;//dp[i-2]
        for(int n:nums){
            int curr = Math.max(prev1, n+prev2); // rob or skip
            prev2 = prev1; // move forward
            prev1 = curr;
        }
        return prev1; // result; by the end of the loop, prev1 contains the best possible amount
        // you can rob from all the houses
    }
    public int robCircular(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(robLinear(nums, 0, n - 2),  // exclude last
                robLinear(nums, 1, n - 1)); // exclude first
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
//This is a classic DP problem. Since we only need the last two results (dp[i-1] and dp[i-2]),
// I use two variables: prev1 and prev2. For each house, I decide whether to rob it (and add to prev2)
// or skip it (use prev1). I take the max of the two choices and keep moving forward.
//We return prev1 because it always holds the maximum amount of money that can be robbed up to
// the current house, considering all valid options (rob or skip) up to that point.

/** What if the houses are arranged in a circle?
 * If you rob the first house, you can't rob the last — and vice versa.
 * So, break it into 2 linear subproblems:
 * Rob from house 0 to n-2 (exclude last)
 * Rob from house 1 to n-1 (exclude first)
 * Then return the max of the two.
 *
 * Example:
 * For nums = [2, 3, 2]:
 * Rob 0 to 1 → max = 3
 * Rob 1 to 2 → max = 3
 * → Return 3
 *
 * For nums = [1, 2, 3, 1]:
 * Rob 0 to 2 → max = 4 (1 + 3)
 * Rob 1 to 3 → max = 3 (2 + 1)
 * → Return 4
 */
