package patternBased.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//1472. Design Browser History
public class DesignBrowserHistory {
    //Why two stacks instead of one?
    //Because navigation is bidirectional.
    private Deque<String> backStack;
    private Deque<String> frontStack;
    private String current;

    public DesignBrowserHistory(String homepage) {
        backStack = new ArrayDeque<>();
        frontStack = new ArrayDeque<>();
        current = homepage;
    }

    public void visit(String url) {
        backStack.push(current);
        current = url;
        //Given requirement- New visit clears forward history
        frontStack.clear();
    }

    public String back(int steps) {
        while(steps > 0 && !backStack.isEmpty()){
            frontStack.push(current);
            current = backStack.pop();
            steps--;
        }
        return current;
    }

    public String forward(int steps) {
        while(steps > 0  && !frontStack.isEmpty()){
            backStack.push(current);
            current = frontStack.pop();
            steps--;
        }
        return current;
    }
}

/**
 * visit()
 * Time: O(1)
 * Space: O(1) extra
 *
 * back() / forward()
 * Worst case: O(steps)
 * Amortized: O(1) per move
 *
 * Total Space
 * O(n) — number of pages visited
 */
