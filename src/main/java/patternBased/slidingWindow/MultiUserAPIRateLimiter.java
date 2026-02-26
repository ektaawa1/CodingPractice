package patternBased.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * You are building a backend system for a service that allows users to make API calls.
 * To prevent abuse, you need to implement a rate limiter:
 * Each user can make at most limit requests per window seconds.
 * The system should support multiple users.
 * Requests can come at any timestamp (in seconds).
 * timestamp is always non-decreasing (next request time ≥ previous).
 *
 * Example-limit = 3, window = 10
 * Requests (userId, timestamp):
 * ("alice", 1)  → true
 * ("alice", 2)  → true
 * ("bob", 3)    → true
 * ("alice", 3)  → true
 * ("alice", 4)  → false  // 4th request in 10-sec window
 * ("alice", 11) → true   // oldest request (t=1) expired
 * ("bob", 12)   → true
 */
public class MultiUserAPIRateLimiter {
    private int limit;
    private int window;
    private Map<String, Deque<Integer>> userRequests;
    public MultiUserAPIRateLimiter(int limit, int window) {
        this.limit = limit;
        this.window = window;
        this.userRequests = new HashMap<>();
    }

    public boolean allowRequest(String userId, int timestamp) {
        //the data is coming as a stream, one request at a time.
        //We want to track requests per user separately.
        //If this is the first time we see this user, there’s no queue yet. So we create a new Deque (queue).
        //If the user already exists, we reuse their queue.
        userRequests.putIfAbsent(userId, new ArrayDeque<>());
        //or use this
        //if (!userRequests.containsKey(userId)) {
        //    userRequests.put(userId, new ArrayDeque<>());
        //}
        Deque<Integer> q = userRequests.get(userId);

        // Remove expired requests
        //sliding window magic
        while (!q.isEmpty() && q.peek() <= timestamp - window) {//we only care about requests in [t-window+1, t] range
            q.poll();//We want to remove requests that are outside the current window.
        }

        if (q.size() < limit) {
            q.offer(timestamp);
            return true;
        }

        return false;
    }
}
/**
 * Ask Clarifying Questions-
 * Are timestamps in seconds? yes
 * Are requests for multiple users? yes
 * Should we store only accepted requests or all requests? Only accepted ones count.
 * Can requests be out of order? No, Assume non-decreasing.
 * Time: O(1) amortized per request (each timestamp enters/exits queue once)
 * Space: O(n) where n = # of requests in current window across all users
 */
//window = 10
//timestamps in queue = [1, 2, 3]
//current timestamp = 12
//check: 1 <= 12 - 10 → 1 <= 2 → yes, remove
//queue now: [2,3]
