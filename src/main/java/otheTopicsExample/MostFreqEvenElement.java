package otheTopicsExample;

import java.util.HashMap;

public class MostFreqEvenElement {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int n:nums){
            if(n%2==0){
                freqMap.put(n, freqMap.getOrDefault(n,0)+1);
            }
        }
        if(freqMap.isEmpty()) return -1;
        int maxFreq = 0;
        int result = Integer.MAX_VALUE;;
        for(int num : freqMap.keySet()){
            int freq = freqMap.get(num);
            if(freq > maxFreq || (freq == maxFreq && num < result)){
                maxFreq = freq;
                result = num;
            }
        }
        return result;
    }
}
//Time = O(n) → building freqMap + one pass over it

//Space = O(n) in worst case (if all even numbers are unique)
/**
 * Examples:
 *
 * Example 1:
 * Input: nums = [0,1,2,2,4,4,1], Output: 2
 * Explanation:
 * The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
 * We return the smallest one, which is 2.
 *
 * Example 2:
 * Input: nums = [4,4,4,9,2,4],  Output: 4
 * Explanation: 4 is the even element appears the most.
 *
 * Example 3:
 * Input: nums = [29,47,21,41,13,37,25,7] ,    Output: -1
 * Explanation: There is no even element.
 */
