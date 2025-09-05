package top150LC.Week1;

import java.util.*;

//49. Group Anagrams
// https://algo.monster/liteproblems/49

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 *
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Use a HashTable
        // Create a map to group the anagrams, where the key is the sorted string, and the
        // value is a list of original strings.
        Map<String,List<String>> anagram_map = new HashMap<>(); //HashMap is a form of HashTable

        for (String s: strs){
            //Convert the string to character array and sort it
            char[] char_arr = s.toCharArray();
            Arrays.sort(char_arr);

            // Create a new string from the sorted character array. Converting char array back to string
            String sortedStr = String.valueOf(char_arr);

            // If the sorted string key is not present in the map, initialize the list.
            // Then add the original string to the list associated with the sorted string key.
            anagram_map.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(s); //Java 8+
        }
        // Return a new list containing all values from the map's lists,
        // effectively grouping all anagrams together.
        return new ArrayList<>(anagram_map.values());
    }
}

//Equivalent Verbose-
/**
 * if (!anagramsMap.containsKey(sortedStr)) {
 *     anagramsMap.put(sortedStr, new ArrayList<>());
 * }
 * anagramsMap.get(sortedStr).add(str);
 */

/**
 * Use computeIfAbsent() to:
 * Check if that sorted string key exists in the map.
 * If it doesn't, it creates a new empty list.
 * Then it adds the original string to the list.
 */

/**
 * Explanation-
 * input is strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Map after loop is
 * {
 *   "aet": ["eat", "tea", "ate"],
 *   "ant": ["tan", "nat"],
 *   "abt": ["bat"]
 * }
 */