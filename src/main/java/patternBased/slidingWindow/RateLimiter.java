package patternBased.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
//Design a rate limiter that allows at most N requests per T seconds.
/**
 * Ask clarifying questions-
 * Is timestamp strictly increasing?
 * Can multiple requests have same timestamp?
 * Should rejected requests be stored?
 */
class RateLimiter {

    private int limit;
    private int window;
    private Deque<Integer> queue;

    public RateLimiter(int limit, int window) {
        this.limit = limit;
        this.window = window;
        this.queue = new ArrayDeque<>();
    }

    public boolean allowRequest(int timestamp) {

        // Remove all requests older than window
        while (!queue.isEmpty() && queue.peek() <= t - window) {
            queue.poll();
        }

        // Check capacity
        if (queue.size() < limit) {
            queue.offer(t);
            return true;
        }

        return false;
    }
}
/**
 * limit = 3
 * window = 10
 * Requests: 1, 2, 3, 4, 11
 * Queue state:
 *
 * t=1 → [1] → allow
 * t=2 → [1,2] → allow
 * t=3 → [1,2,3] → allow
 * t=4 → [1,2,3] → reject
 * t=11 → remove ≤ 1 → [2,3] → allow → [2,3,11]
 */
/**
 * Question Rules
 * timestamp is in seconds (monotonic increasing)
 * Return true if request allowed
 * Return false if rejected
 * Only consider requests within last T seconds
 * Example-
 * RateLimiter(3, 10)
 * allowRequest(1)  → true
 * allowRequest(2)  → true
 * allowRequest(3)  → true
 * allowRequest(11) → true  (timestamp 1 expired)
 * allowRequest(12) → true
 * allowRequest(13) → false (3 requests already in window)
 */

