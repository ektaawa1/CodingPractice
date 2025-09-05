package top150LC.Week3;

import java.util.Stack;

//155. Min Stack
// https://algo.monster/liteproblems/155
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

//    private Deque<Integer> stack;
//    private Deque<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

//        stack = new ArrayDeque<>();     // main stack
//        minStack = new ArrayDeque<>();  // keeps track of minimum values
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.empty()){
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

// TC = O(1)
// SC = O(n)

/**
 * Explanation-
 * I have initialized stacks, a main stack and a min_stack (which will keep track of the minimum value.)
 *  Now, while pushing the value in the stack, I am also making sure to keep a track of current
 *  minimum value by checking-
 *  If the min_stack is empty then push the val into it which means val becomes the current min value.
 *  If the min_stack is not empty, I am comparing the val with the
 *  top value of min_stack. Whichever value is the minimum, I am pushing the value into the min_stack.
 *  In the pop function, I am popping out the value from both the stack and the min_stack so that the
 *  minimum value is maintained. In the top(), I am returning the top most value from the stack, i.e., stack[-1]
 *  In the getMin(), I am returning the top most value from the min_stack if the min_stack is not empty,
 *  as the min_stack will hold the current most minimum value at the top.
 */

/**
 * | Operation    | `stack` (main stack) | `minStack` (stores min so far) | Explanation                 |
 * | ------------ | -------------------- | ------------------------------ | --------------------------- |
 * | push(3)      | \[3]                 | \[3]                           | First element, so min is 3. |
 * | push(5)      | \[3, 5]              | \[3, 3]                        | Min of (5, 3) is 3.         |
 * | push(2)      | \[3, 5, 2]           | \[3, 3, 2]                     | Min of (2, 3) is 2.         |
 * | push(1)      | \[3, 5, 2, 1]        | \[3, 3, 2, 1]                  | Min of (1, 2) is 1.         |
 * | pop()        | \[3, 5, 2]           | \[3, 3, 2]                     | Pops from both stacks.      |
 * | top() → 2    | \[3, 5, 2]           | \[3, 3, 2]                     | Top element is 2.           |
 * | getMin() → 2 | \[3, 5, 2]           | \[3, 3, 2]                     | Peek `minStack` → 2.        |
 */

/**
 * Key Observations
 * stack → keeps all values.
 * minStack → keeps the minimum value up to that index (in sync with stack).
 *
 * When you push:
 * Always push into stack.
 * Push into minStack the smaller between current value & last min.
 * When you pop:
 * Pop from both stacks to keep them in sync.
 * O(1) for getMin() because minStack.peek() gives you the answer instantly.
 */
