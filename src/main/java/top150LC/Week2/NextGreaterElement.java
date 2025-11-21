package top150LC.Week2;

import java.util.Stack;

/**
 * Problem: Next Greater Element (NGE)
 *
 * For each element in the array, find the first element to the right that is greater.
 * If none exists → return -1.
 *
 * Example:
 * Input: [4, 5, 2, 25]
 * Output: [5, 25, 25, -1]
 */
public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();  // will store indices

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Pop all elements smaller than or equal to nums[i]
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element to the right
            result[i] = stack.isEmpty() ? -1 : nums[stack.peek()];

            // Push current index
            stack.push(i);
        }

        return result;
    }
}
