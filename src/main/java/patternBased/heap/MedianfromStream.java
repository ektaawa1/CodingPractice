package patternBased.heap;

import java.util.PriorityQueue;
//295. Find Median from Data Stream
/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 */
public class MedianfromStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianfromStream() {
        maxHeap =new PriorityQueue<>((a,b)-> b-a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        //send it to minHeap
        minHeap.offer(maxHeap.poll());
        //Keep max heap as the larger one if size is odd
        if(maxHeap.size() < minHeap.size()){
            //add back to max heap
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){//odd size
            return maxHeap.peek();//max heap hold the middle value on the top
        }
        //for even size, return the mean of the tops from both the heaps
        return (maxHeap.peek() + minHeap.peek())/2.0;
    }
}

/**
 * Time Complexity: O(log n) for addNum and O(1) for findMedian.
 * Space Complexity: O(n) to store the elements.
 */