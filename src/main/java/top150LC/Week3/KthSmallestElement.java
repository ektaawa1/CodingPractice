package org.Week3;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(); //stores largest element at top
        for(int num: nums){
            maxHeap.offer(num);
            if(maxHeap.size()>k){
                maxHeap.poll(); // remove the largest to keep k smallest
            }
        }
        return maxHeap.peek(); //kth smallest element is being returned
    }
}
