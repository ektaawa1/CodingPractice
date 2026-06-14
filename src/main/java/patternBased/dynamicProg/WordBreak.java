package patternBased.dynamicProg;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//139. Word Break

/**
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * s = "catsandog"
 * dict = ["cat","cats","and","sand","dog"]
 * output: false
 */
public class WordBreak {
    // brute force way to look at "Word Break" is to try every possible way to split the string
    // DP approach
    public boolean wordBreak(String s, List<String> wordDict) {// List search operation is O(n)
        // List search operation is O(n) → correct, because List.contains() is linear scan.
        // That’s why we convert to HashSet for O(1) lookup.
        int strLen = s.length();
        HashSet<String> dictSet = new HashSet<>(wordDict);// search operation is O(1)
        //Good optimization — HashSet makes `contains()` O(1) average case.

        boolean arr[] = new boolean[strLen+1];// since we have to work with substring
        // arr[i] = true means substring(0..i-1) can be split using dict.
        // n+1 size because we need dp[0] = true as base case.
        arr[0] = true; // empty string is always splittable (base case)
        // empty string is always splittable → base condition.
        for(int i = 1; i<= strLen; i++){
            // iterate over all prefixes ending at i (exclusive).
            for(int j = 0; j<i; j++){
                // check every possible cut between 0..i.
                if(arr[j] && dictSet.contains(s.substring(j, i))){
                    // if prefix up to j is splittable
                    // and current substring s[j..i-1] is in dict
                    // → then whole s[0..i-1] is splittable.
                    arr[i] = true;
                    break; //no need to check further for this i
                    // no need to check more cuts for this i.
                }
            }
        }
        return arr[strLen]; // final answer: can whole string be split?
    }

    //prefer this one
    public boolean wordBreakBottomUp(String s, List<String> wordDict) {
        if(s == null || s.isEmpty()) return true;
        if(wordDict == null || wordDict.size() == 0) return false;

        int l = s.length();
        boolean[] arr = new boolean[l + 1];//it represents position and not char
        arr[0] = true;//why??
        //0 1 2 3 4 5 6 7 8
        //  e k t a c o d e
        for(int i = 0; i < l; i++) {
            if(!arr[i]) continue;// if false keep moving ahead
            for(String word : wordDict) {// for every index i, check with all words from the word dict
                int len = word.length();
                if(i + len > l) continue;
                if(s.substring(i, i + len).equals(word)) {
                    arr[i + len] = true;
                }
            }
        }
        return arr[l];
    }
// Time: O(n × w × Len)
//   l = string length
//   w = number of words in dict
//   Len = average word length (for substring + equals)
// Space: O(n)
    //dp[0] = can I reach position 0? (before string starts)
    //dp[4] = can I reach position 4? (after "leet")
    //dp[8] = can I reach position 8? (after entire string)



    //bruteforce recursion solution- TC is O(2^N) & SC is O(N)

    /**
     * canBreak(s, dict, 0)
     *   try "l"     → not in dict
     *   try "le"    → not in dict
     *   try "lee"   → not in dict
     *   try "leet"  → IN DICT (YES)
     *     canBreak(s, dict, 4)
     *       try "c"    → not in dict
     *       try "co"   → not in dict
     *       try "cod"  → not in dict
     *       try "code" → IN DICT (YES)
     *         canBreak(s, dict, 8)
     *           start==length → return TRUE (YES)
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        return canBreak(s, new HashSet<>(wordDict), 0);
    }

    private boolean canBreak(String s, Set<String> wordSet, int i) {
        // Base Case: If we reached the end, we succeeded!
        if (i == s.length()) return true;

        // Try every possible end position for a word
        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (wordSet.contains(sub) && canBreak(s, wordSet, j)) {
                return true;
            }
        }
        return false;
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
 * "he" in dict and dp[0]=T → dp[2]=T.
 * dp = [T, F, T, F, F, F, F, F, F, F, F]
 *
 * i = 3..4 ("hel", "hell")
 *
 * Not in dict → dp[3]=dp[4]=F.
 *
 * i = 5 → "hello"
 *
 * Last substrings: "ello"  in dict, but we need dp[1]=T (for the part before it "h").
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
 * dp[10] = false → "helloworld" cannot be segmented.
 */
/**
 * s = "leetcode", n=8
 * dict = ["leet", "code"]
 * dp = [T, F, F, F, F, F, F, F, F]
 *       0  1  2  3  4  5  6  7  8
 *
 * i=0: dp[0]=T → try all words
 *   "leet": s(0,4)="leet" ✅ → dp[4]=T
 *   "code": s(0,4)="leet"≠"code" ❌
 *   dp = [T,F,F,F,T,F,F,F,F]
 *
 * i=1: dp[1]=F → SKIP (can't jump from invalid position)
 * i=2: dp[2]=F → SKIP
 * i=3: dp[3]=F → SKIP
 *
 * i=4: dp[4]=T → try all words
 *   "leet": s(4,8)="code"≠"leet" ❌
 *   "code": s(4,8)="code" ✅ → dp[8]=T
 *   dp = [T,F,F,F,T,F,F,F,T]
 *
 * i=5,6,7: dp=F → SKIP
 *
 * i=8: dp[8]=T but i=n → loop ends
 *
 * Return dp[8] = true
 */
