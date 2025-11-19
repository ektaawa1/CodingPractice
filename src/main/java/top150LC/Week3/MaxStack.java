package top150LC.Week3;

import java.util.Stack;

class MaxStack {
    Stack<Integer> stack;//helper stack
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (maxStack.empty()) {
            maxStack.push(val);
        } else {
            maxStack.push(Math.max(val, maxStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        maxStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMax() {
        return maxStack.peek();
    }
}
//TC = O(1)

