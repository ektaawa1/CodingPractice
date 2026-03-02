package patternBased.heap;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public int findKthSmallest(int[] nums, int k) {
        //By default, Java PriorityQueue is a min-heap.
        //If you don’t provide a comparator, the smallest element will always be at the top.
        //but you need max element at the top.
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);
        //OR PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: nums){
            maxHeap.offer(num);
            if(maxHeap.size()>k){
                maxHeap.poll(); // remove the largest to keep k smallest
            }
        }
        return maxHeap.peek(); //kth smallest element is being returned
    }
}
