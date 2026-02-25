package patternBased.stack;

import java.util.Arrays;
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
    //prefer this
    public int[] nextGreaterElement(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];  // handle null or empty

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // initialize all elements to -1

        Stack<Integer> stack = new Stack<>(); // store indices

        for(int i = 0; i < n; i++) {
            // If current element is greater than the element at index on top of stack
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i]; // update result for that index
            }
            stack.push(i); // push current index to stack
        }

        return result;
    }

}
/**
 * | i | stack | result        | action                                                             |
 * | - | ----- | ------------- | ------------------------------------------------------------------ |
 * | 0 | [0]   | [-1,-1,-1,-1] | push index 0                                                       |
 * | 1 | []    | [5,-1,-1,-1]  | 5 > 4 → pop 0, result[0]=5, push 1                                 |
 * | 2 | [1,2] | [5,-1,-1,-1]  | 2 < 5 → push 2                                                     |
 * | 3 | []    | [5,25,25,-1]  | 25 > 2 → pop 2, result[2]=25; 25 > 5 → pop 1, result[1]=25; push 3 |
 */
