package grind75;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given:
 * Array arr of length n
 * Integer k
 * Operation (can do at most k times):
 * Pick any element, divide by 2, ceil it.
 * Goal: minimize the sum after k operations.
 * arr = [10, 20, 7], k = 4
 */
public class FindMinSum {
    public int minSumAfterKOperations(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            maxHeap.offer(num);
        }

        for (int i = 0; i < k; i++) {
            int max = maxHeap.poll();
            maxHeap.offer((max + 1) / 2); // ceil division
        }

        int sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }

        return sum;
    }
    //By using minHeap
    public int minSum(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(-num);   // store negatives
        }

        while (k-- > 0) {
            int max = -pq.poll();          // convert back
            max = (max + 1) / 2;           // ceil division
            pq.add(-max);                  // store again as negative
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += -pq.poll();
        }

        return sum;
    }

}
//TC: O((n + k) log n) → heapify + k operations
//SC: O(n) → max-heap storage

/**
 * Step by step (minimizing sum):
 * Pick max element (20) → ceil(20/2) = 10 → new array [10, 10, 7]
 * Pick max element (10) → ceil(10/2) = 5 → new array [5, 10, 7]
 * Pick max element (10) → ceil(10/2) = 5 → new array [5, 5, 7]
 * Pick max element (7) → ceil(7/2) = 4 → new array [5, 5, 4]
 * Sum = 14 → minimal. ✅
 * Note-Java PriorityQueue is min-heap by default, so for greedy problems where we must always pick the largest element,
 * we explicitly use Collections.reverseOrder() to form a max-heap.
 */
