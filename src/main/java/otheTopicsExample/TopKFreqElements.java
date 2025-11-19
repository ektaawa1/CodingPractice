package otheTopicsExample;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2,   Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1,   Output: [1]
 *
 * Example 3:
 * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2,    Output: [1,2]
 */
public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        //HashMap & MinHeap will be used

        //Step1: build a freq map
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }

        //Step2: Build a Min Stack of size k (smallest frequency at the top)
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a, b)-> a.getValue() - b.getValue());// letting miHeap know
        // that the sorting is based on value(freq) of a key, sorting in ascending order
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size()>k){ //if minHeap is full
                minHeap.poll(); // remove the one with smallest frequency
            }
        }

        //Step3: Extract the keys for the top K frequent elements
        //Build the output array
        int[] outputArr = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            outputArr[i++] = minHeap.poll().getKey();
        }
        return outputArr;
    }
}
/**
 Total time: O(n log k) — better than sorting all elements (which is O(n log n))
 Space: O(n) */
