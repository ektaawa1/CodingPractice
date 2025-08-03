package org.Week3;

import java.util.ArrayDeque;
import java.util.Deque;
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
 * I have initialized stack which is the main stack and a min_stack which will keep track of the minimum value.
 *  Now, while pushing the value in the stack, I am also making sure to keep a track of current minimum value by checking- If the min_stack is
 *  empty then push the val into it which means val becomes the current min value. If the min_stack is not empty, I am comparing the val with the
 *  top value of min_stack. Whichever value is the minimum, I am pushing the value into the min_stack.
 *  In the pop function, I am popping out the value from both the stack and the min_stack so that the minimum value is maintained.
 *  In the top(), I am returning the top most value from the stack, i.e., stack[-1]
 *  In the getMin(), I am returning the top most value from the min_stack if the min_stack is not empty, as the min_stack will hold the current most
 *  minimum value at the top.
 */
