package patternBased.slidingWindow;
// 2107. Number of Unique Flavors After Sharing K Candies

import java.util.HashMap;

/**
 * You are given a 0-indexed integer array candies, where candies[i] represents the
 * flavor of the ith candy. Your mom wants you to share these candies with your
 * little sister by giving her k consecutive candies, but you want to keep as many flavors
 * of candies as possible. Return the maximum number of unique flavors of candy
 * you can keep after sharing with your sister.
 */
public class NoOfUniqueFlavorsOfCandies {
    public int shareCandies(int[] candies, int k) {
        //fixed window k
        // sliding window
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int candy: candies){
            freqMap.put(candy,freqMap.getOrDefault(candy, 0)+1);
        }
        int uniqueSize = freqMap.size();
        int maxUniqueFlavors = 0;
        int left = 0;

        for(int right = 0; right<candies.length; right++){
            // remove right candy
            int c = candies[right];
            freqMap.put(c, freqMap.get(c) - 1);
            if (freqMap.get(c) == 0) uniqueSize--;

            // window size k
            if (right - left + 1 > k) {
                int addBack = candies[left++];
                freqMap.put(addBack, freqMap.getOrDefault(addBack, 0) + 1);
                if (freqMap.get(addBack) == 1) uniqueSize++;
            }

            if (right - left + 1 == k) {
                maxUniqueFlavors = Math.max(maxUniqueFlavors, uniqueSize);
            }
        }
        return maxUniqueFlavors;
    }
}
//We are not tracking unique flavors inside the window.
// We are tracking: unique flavors OUTSIDE the window (remaining candies)
//My hashmap always represents the candies I still have AFTER giving away the current window.

/**
 So:

 Removing from the map = giving away candy

 Adding back to the map = window moved, candy returned

 unique = number of flavors remaining
 When window size == k:
 If I give away THESE k consecutive candies, how many unique flavors do I still have?
 Why we don’t count inside the window

 Because the question asks:

 unique flavors AFTER sharing k candies

 Not:

 inside the window

 before sharing

 So counting remaining is simpler.*/

/**
 * Input: candies = [1,2,2,3,4,3], k = 3
 * Output: 3
 * Explanation:
 * Give the candies in the range [1, 3] (inclusive) with flavors [2,2,3].
 * You can eat candies with flavors [1,4,3].
 * There are 3 unique flavors, so return 3.
 *
 * Input: candies = [2,2,2,2,3,3], k = 2
 * Output: 2
 * Explanation:
 * Give the candies in the range [3, 4] (inclusive) with flavors [2,3].
 * You can eat candies with flavors [2,2,2,3].
 * There are 2 unique flavors, so return 2.
 * Note that you can also share the candies with flavors [2,2] and eat the candies with flavors [2,2,3,3].
 *
 * Input: candies = [2,4,5], k = 0
 * Output: 3
 * Explanation:
 * You do not have to give any candies.
 * You can eat the candies with flavors [2,4,5].
 * There are 3 unique flavors, so return 3.
 */
