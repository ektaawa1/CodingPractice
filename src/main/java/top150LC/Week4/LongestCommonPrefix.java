package org.Week4;

//The time complexity of the code is O(n * m), where n is the number of strings in the given list,
// and m represents the length of the shortest string in the list.
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        // Start with the first word as prefix
        // Considering 1st word as the longest than the other words
        String str = strs[0];
        for(int i = 1; i<strs.length; i++){
            // Keep trimming the prefix until it matches the current string
            while(!strs[i].startsWith(str)){
                str = str.substring(0, str.length()-1);

                if(str.isEmpty()){
                    return "";
                }
            }
        }
        return str;
    }
}

/**
 * Let's take an example:
 * String[] strs = {"flower", "flow", "flight"};
 * Initially:
 * prefix = "flower"
 * Compare with "flow" → "flower" does not start with "flow"
 * So we shorten:
 * "flower" → "flowe"
 * "flowe" → "flow"
 * Now "flow" matches "flow" → continue
 *
 * Next compare "flow" with "flight" → "flight" does not start with "flow"
 * So we shorten:
 * "flow" → "flo"
 * "flo" → "fl"
 * "flight" starts with "fl" → done
 * Final result: "fl"
 *
 * So what does prefix.substring(0, prefix.length() - 1) do?
 * It keeps removing the last character from prefix until a match is found.
 * For example:
 * "flow" → "flo"
 * "flo" → "fl"
 * "fl" → "f"
 * "f" → ""
 */

/**
 * String[] strs = {"flower", "flow", "flight"};
 * String str = "flo";
 * strs[0].startsWith(str); // true  → "flower" starts with "flo"
 * strs[1].startsWith(str); // true  → "flow" starts with "flo"
 * strs[2].startsWith(str); // false → "flight" does not start with "flo"
 */