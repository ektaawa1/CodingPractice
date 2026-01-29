package patternBased.slidingWIndow;
// 904. Fruit Into Baskets
// Given the integer array fruits, return the maximum number of fruits you can pick.

import java.util.HashMap;

/**
 * Example-
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 */
public class FruitIntoBasket {
    // Maintain a window with at most 2 distinct numbers and maximize its length.
    public int totalFruit(int[] fruits) {
        //  atmost 2 i.e., 2 baskets
        // which means at most two types of digits i can choose
        // find the freq of each number

        int maxLen = 0;
        int left = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int right = 0; right < fruits.length; right++){
            freqMap.put(fruits[right], freqMap.getOrDefault(fruits[right], 0) + 1);

            // We allow more than 2 temporarily, but we shrink immediately when size exceeds 2.
            // We insert first, then fix the window
            while(freqMap.size() > 2){
                freqMap.put(fruits[left], freqMap.get(fruits[left])-1);
                if(freqMap.get(fruits[left]) == 0){
                    freqMap.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

//Pseudocode-
/**
 * left = 0
 * freqMap = {}
 *
 * for right in array:
 *     add arr[right] to freqMap
 *
 *     while freqMap.size() > 2:
 *         reduce arr[left] count
 *         if count becomes 0:
 *             remove from map
 *         left++
 *
 *     update max length
 */

/**
 * Dry Run-
 * [1, 2, 3, 2, 2]
 * map-> {1,1}, size = 1 so okay
 * window = [1], maxLen = 1
 *
 * map-> {1=1, 2=1}, size = 2 so okay
 * window = [1,2], maxLen = 2
 *
 * map-> {1-1, 2-1, 3-1}, size = 3 exceeded so shrink
 * map-> {2-1, 3-1}, left = 1
 * window = [2,3], maxLen = 2
 *
 * map-> {2=2, 3=1}
 * map.size() = 2 → valid
 * window = [2,3,2]
 * maxLen = 3
 *
 * map-> {2-3, 3-1}
 * map.size() = 2 -> valid
 * window = [2,3,2,2], maxLen =4
 */
