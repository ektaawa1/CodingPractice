package top150LC.Week7;

import java.util.HashSet;
import java.util.List;

//139. Word Break

/**
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    // DP approach
    public boolean wordBreak(String s, List<String> wordDict) {// List search operation is O(n)
        // List search operation is O(n) → correct, because List.contains() is linear scan.
        // That’s why we convert to HashSet for O(1) lookup.
        int strLen = s.length();
        HashSet<String> dictSet = new HashSet<>(wordDict);// search operation is O(1)
        // ✅ Good optimization — HashSet makes `contains()` O(1) average case.

        boolean arr[] = new boolean[strLen+1];// since we have to work with substring
        // ✅ arr[i] = true means substring(0..i-1) can be split using dict.
        // n+1 size because we need dp[0] = true as base case.
        arr[0] = true; // empty string is always splittable (base case)
        // ✅ empty string is always splittable → base condition.
        for(int i = 1; i<= strLen; i++){
            // ✅ iterate over all prefixes ending at i (exclusive).
            for(int j = 0; j<i; j++){
                // ✅ check every possible cut between 0..i.
                if(arr[j] && dictSet.contains(s.substring(j, i))){
                    // ✅ if prefix up to j is splittable
                    // and current substring s[j..i-1] is in dict
                    // → then whole s[0..i-1] is splittable.
                    arr[i] = true;
                    break; //no need to check further for this i
                    // ✅ no need to check more cuts for this i.
                }
            }
        }
        return arr[strLen]; // ✅ final answer: can whole string be split?
    }
}
/**
 * time complexity:
 * Outer loop runs n times. Inner loop runs up to n times.
 * Each substring(j, i) is O(n) (Java creates a new string).
 * So worst-case O(n³).
 * But in practice, people optimize by limiting substring length (max word length in dict), so it becomes closer to O(n²).
 *
 * Time: O(n² * L) in the naive view (n = s.length, L = average substring cost). In practice with small words and a HashSet it behaves like O(n²).
 * Space: O(n) for the dp array + O(m) for the dictionary set (m = total dictionary size).
 * (If you worry about substring cost, you can optimize with a Trie or check only j such that i-j ≤ maxWordLen.)
 */

/**
 * Example 2 — "helloworld", dict = ["world","ello","he"]
 * Step 1: Setup
 * String length = 10 → dp size = 11.
 * dp = [T, F, F, F, F, F, F, F, F, F, F]
 *
 * Step 2: Fill dp
 * i = 2 → "he"
 *
 * "he" ✅ in dict and dp[0]=T → dp[2]=T.
 * dp = [T, F, T, F, F, F, F, F, F, F, F]
 *
 * i = 3..4 ("hel", "hell")
 *
 * Not in dict → dp[3]=dp[4]=F.
 *
 * i = 5 → "hello"
 *
 * Last substrings: "ello" ✅ in dict, but we need dp[1]=T (for the part before it "h").
 * dp[1] = F → can’t use.
 * So dp[5] stays F.
 *
 * This is where "ello" fails → because "h" isn’t in the dictionary.
 *
 * Later (i = 10 → "helloworld")
 *
 * "world" is in dict, but we need dp[5]=T.
 * But dp[5] is F (we couldn’t break "hello").
 * So dp[10] = F.
 *
 * Step 3: Result
 *
 * dp[10] = false → "helloworld" cannot be segmented. ❌
 */
