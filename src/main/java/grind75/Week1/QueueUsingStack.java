package grind75.Week1;

import java.util.Stack;
// LIFO to FIFO
public class QueueUsingStack {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public QueueUsingStack() {
        inStack = new Stack<>(); //LIFO //used for enqueue
        outStack = new Stack<>(); //used for dequeue
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        shuffleElements();
        return outStack.pop();
    }

    public int peek() {
        shuffleElements();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void shuffleElements(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
}

/**
 * Dry Run-
 * MyQueue q = new MyQueue();
 * q.push(1); // inStack = [1]
 * q.push(2); // inStack = [1,2]
 * q.push(3); // inStack = [1,2,3]
 *
 * q.peek();  // shift → outStack = [3,2,1], peek = 1
 * q.pop();   // pop from outStack → 1, outStack = [3,2]
 * q.pop();   // pop from outStack → 2, outStack = [3]
 * q.empty(); // false
 */

/**
 * Complexity
 * Push: O(1)
 * Pop/Peek: Amortized O(1) (sometimes O(n), but rare)
 * (each element is moved at most once from inStack to outStack)
 * (On average, each operation is constant time, even if some individual operations take longer.)
 * Empty: O(1)
 *
 * SC = O(n) (where n = number of elements in the queue)
 * At first glance, you might think it’s O(2n) since there are 2 stacks.
 * But Big-O ignores constant factors.
 * So whether it’s n or 2n, it simplifies to O(n).
 */
