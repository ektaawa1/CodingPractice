package patternBased.slidingWIndow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Implement the MovingAverage class:
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 */

/**
 * Example 1:
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 */
class MovingAverage {
    Queue<Integer> queue;
    int maxSize;
    double windowSum;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        maxSize = size;
        windowSum = 0;
    }

    public double next(int val) {
        queue.offer(val);
        windowSum += val;

        if(queue.size() > maxSize){
            windowSum -= queue.poll();
        }
        return windowSum/queue.size();// We use queue.size() because during the first few calls,
        // the window is NOT full yet. Using maxSize would give wrong averages at the beginning
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

/**
 Time per operation: O(1)
 Space: O(k) */

/**
 * Note: Why Queue
 * If input was array-based (not stream), you could do:
 * windowSum += arr[right];
 * windowSum -= arr[right - k];
 *
 *
 * But in a stream:
 * You don’t have right - k
 * You don’t know what arrived k steps ago
 * Queue remembers that for you
 */
