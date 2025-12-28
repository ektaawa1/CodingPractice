package otheTopicsExample;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargestInStream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/**
 Constructor
 Time: O(n log k), Space: O(k)

 add(val)
 Time: O(log k), Space: O(k)
 */

//“Sorting is O(n log n) per insertion, which is inefficient for streaming data.”
//“No, PriorityQueue is not thread-safe. We’d need synchronization or a concurrent structure.”
//“Heap operations still scale efficiently because we only store k elements.”
