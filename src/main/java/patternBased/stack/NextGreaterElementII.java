package patternBased.stack;
//503. Next Greater Element II

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
 * return the next greater number for every element in nums.
 * The next greater number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 * If it doesn't exist, return -1 for this number.
 */
public class NextGreaterElementII {
    //Circular so [1,2,1] → behaves like → [1,2,1,1,2,1]
    //Monotonic decreasing stack of INDICES
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< 2*n; i++){ //O(2n)
            int currNum = nums[i%n];//nums[0],nums[1], nums[2], nums[3], nums[4]
            while(!stack.isEmpty() && nums[stack.peek()] < currNum){
                int oldIndex = stack.pop();
                result[oldIndex] = currNum;//2,-1,-1,-1,-1
                //2,3,...
                //2,3,4...
                //2,3,4...then second pass from i = 5, stack = [3,4]

            }
            if(i<n){
                stack.push(i);
            }
        }
        return result;
    }
}
//Each index is: pushed once and popped once
//Push operations → n, Pop operations → n, Loop iterations → 2n
//So TC = O(n) (Amortized), SC = O(n)

/**
 * Examples-
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 * we iterate 5*2 = 10 times here.
 * result = [-1, -1, -1, -1, -1]
 * 1st Pass-
 * | i | i % n | curr | Stack (indices) | Action                      | Result           |
 * | - | ----- | ---- | --------------- | --------------------------- | ---------------- |
 * | 0 | 0     | 1    | []              | push 0                      | [-1,-1,-1,-1,-1] |
 * | 1 | 1     | 2    | [0]             | pop 0 → result[0]=2, push 1 | [2,-1,-1,-1,-1]  |
 * | 2 | 2     | 3    | [1]             | pop 1 → result[1]=3, push 2 | [2,3,-1,-1,-1]   |
 * | 3 | 3     | 4    | [2]             | pop 2 → result[2]=4, push 3 | [2,3,4,-1,-1]    |
 * | 4 | 4     | 3    | [3]             | 3 < 4 → push 4              | [2,3,4,-1,-1]    |
 * 
 * Second pass- Circular Effect
 * | i | i % n | curr | Stack | Action                     | Result        |
 * | - | ----- | ---- | ----- | -------------------------- | ------------- |
 * | 5 | 0     | 1    | [3,4] | no pop                     | [2,3,4,-1,-1] |
 * | 6 | 1     | 2    | [3,4] | no pop                     | [2,3,4,-1,-1] |
 * | 7 | 2     | 3    | [3,4] | no pop (equal not allowed) | [2,3,4,-1,-1] |
 * | 8 | 3     | 4    | [3,4] | pop 4 → result[4]=4        | [2,3,4,-1,4]  |
 * | 9 | 4     | 3    | [3]   | no pop                     | [2,3,4,-1,4]  |
 */
