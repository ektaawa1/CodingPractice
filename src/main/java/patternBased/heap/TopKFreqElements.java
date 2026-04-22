package patternBased.heap;

import java.util.*;

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
        if(nums == null || nums.length == 0){
            //return new int[0];
            //OR
            return new int[]{};
        }

        //Step1: build a freq map
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }
        //if k is greater than nums' length
        k = Math.min(k, freqMap.size());

        //Step2: Build a Min Stack of size k (smallest frequency at the top)
        //this is a Comparator
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
        //or for (int i = 0; i < k; i++) {
        //        result[i] = minHeap.poll().getKey();
        //    }
        return outputArr;
    }
    //If TC is needed as O(n) then use bucket sort approach
    public int[] topKFrequentOptimized(int[] products, int k) {
        if (products == null || products.length == 0) return new int[0];

        // 1. Build frequency map - O(N)
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int p : products) {
            freqMap.put(p, freqMap.getOrDefault(p, 0) + 1);
        }

        // 2. Create buckets. The index represents the frequency.
        // The max possible frequency is products.length.
        //is a row of boxes (an array), where each box is itself a list.
        //i.e., an array of list
        List<Integer>[] buckets = new ArrayList[products.length + 1];

        // 3. Fill buckets - O(N)
        for (int key : freqMap.keySet()) {
            int value = freqMap.get(key);
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(key);
        }

        // 4. Collect Top K by iterating backwards from the highest frequency - O(N)
        int[] result = new int[k];
        int counter = 0;

        for (int i = buckets.length - 1; i >= 0 && counter < k; i--) {
            if (buckets[i] != null) {
                for (int id : buckets[i]) {
                    result[counter++] = id;
                    if (counter == k) break;
                }
            }
        }

        return result;
    }
}
/**
 Total time: O(n log k) — better than sorting all elements (which is O(n log n))
 Space: O(D) where D is the no. of distinct elements */

//While the Min-Heap approach is excellent (and often what interviewers expect first),
// Bucket Sort is the "level up" solution because it achieves Linear Time Complexity O(N).

/**
 * How Bucket Sort Works (Step-by-Step)
 * Instead of sorting frequencies, we use the frequencies as array indices.
 * Since a product can't appear more than $N$ times (where $N$ is the total number of views),
 * our frequencies are naturally bounded.Count Frequencies: Just like before,
 * use a HashMap to get {ID: Count}.Create Buckets: Create an array of Lists
 * where the index represents the frequency. The size of this array will be N + 1.
 * Fill Buckets: If Product $A$ appears 3 times, put ID $A$ into buckets[3].
 * Collect Top K: Iterate through the buckets array from the end (highest frequency)
 * toward the beginning. Collect IDs until you have $K$ elements.
 */

/**
 * Bucket Sort-
 * If nums = [1,1,1,2,2,3], your bucket array would look like this:
 * Index 1 (Freq 1): [3]
 * Index 2 (Freq 2): [2]
 * Index 3 (Freq 3): [1]
 * Index 4-6: null (unused)
 */
