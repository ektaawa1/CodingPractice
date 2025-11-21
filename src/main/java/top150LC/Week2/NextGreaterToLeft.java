package top150LC.Week2;

import java.util.Stack;

/**
 * 1️⃣ Change the direction of traversal
 *
 * For Right → you scan right → left
 * For Left → you scan left → right
 * 2️⃣ Comparison remains the SAME as NGE
 * 3️⃣ But stack stores values not indices
 */
public class NextGreaterToLeft {

    public int[] nextGreaterToLeft(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Pop all elements smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // If stack empty → no greater element on left
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element (because this may be NGL for upcoming numbers)
            stack.push(nums[i]);
        }

        return result;
    }
}
