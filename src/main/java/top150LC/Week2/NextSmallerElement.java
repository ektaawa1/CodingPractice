package top150LC.Week2;

import java.util.Stack;

public class NextSmallerElement {

    public int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();  // stores indices

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Pop all elements greater than or equal to current
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            // Top of stack is the next smaller element
            result[i] = stack.isEmpty() ? -1 : nums[stack.peek()];

            // Push current index
            stack.push(i);
        }

        return result;
    }
}
