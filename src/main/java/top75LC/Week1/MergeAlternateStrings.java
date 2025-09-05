package top75LC.Week1;

/**
 * Example 1: Input: word1 = "abc", word2 = "pqr", Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 *
 * Example 2: Input: word1 = "ab", word2 = "pqrs", Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 *
 * Example 3: Input: word1 = "abcd", word2 = "pq", Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 */
public class MergeAlternateStrings {
    //TC = O(m+n)
    //SC = O(m+n)
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder result = new StringBuilder();

        // Merge characters alternately from both strings
        while(i < word1.length() && j < word2.length()){
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        // Append remaining characters from word1
        while(i < word1.length()){
            result.append(word1.charAt(i++));
        }

        // Append remaining characters from word2
        while(j < word2.length()){
            result.append(word2.charAt(j++));
        }
        return result.toString();
    }
}

/**
 * Function mergeAlternately(word1, word2):
 *     Initialize pointer i = 0  // index for word1
 *     Initialize pointer j = 0  // index for word2
 *     Initialize result as empty string builder
 *
 *     WHILE i < length(word1) AND j < length(word2):
 *         Append word1[i] to result
 *         Append word2[j] to result
 *         Increment i and j
 *
 *     WHILE i < length(word1):   // Append remaining characters of word1
 *         Append word1[i] to result
 *         Increment i
 *
 *     WHILE j < length(word2):   // Append remaining characters of word2
 *         Append word2[j] to result
 *         Increment j
 *
 *     RETURN result as string
 */
