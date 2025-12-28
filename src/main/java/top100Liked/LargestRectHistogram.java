package top100Liked;

import java.util.Stack;

public class LargestRectHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currHeight;
            if (i == heights.length) {
                currHeight = 0;  // Sentinel
            } else {
                currHeight = heights[i];
            }
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
/**
 Stack stores indices of bars in increasing height order.
 currHeight < heights[stack.peek()] means:
 The bar at the top of the stack cannot extend further to the right.
 Its right boundary is now fixed at the current index i.
 So we can compute the area for this bar.

 You only calculate area when the current bar is smaller than the stack top.
 Otherwise, we just push the current index and move forward.
 This ensures every bar is considered exactly once for max area.
 */
