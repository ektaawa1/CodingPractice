package org.Week4;

import java.util.HashMap;

/**
 * Examples-
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length){
            return false;
        }
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();

        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = strs[i];

            if(map1.containsKey(ch)){
                if(!map1.get(ch).equals(word)){
                    return false;
                }
            }else {
                map1.put(ch, word);
            }

            if(map2.containsKey(word)){
                if(!map2.get(word).equals(ch)){
                    return false;
                }
            }else {
                map2.put(word,ch);
            }
        }
        return true;
    }
}

//TC = O(n)
//SC = O(n)

/**
 * Instead of maintaining two maps (char → word and word → char),
 * you can use one map with a composite key (i.e., mapping pattern character to word),
 * and a HashSet to track already assigned words.
 */

//for (int i = 0; i < pattern.length(); i++) {
//char ch = pattern.charAt(i);
//String word = words[i];
//
//            if (!map.containsKey(ch)) {
//        if (assignedWords.contains(word)) return false; // Word already assigned to another character
//        map.put(ch, word);
//                assignedWords.add(word);
//            } else {
//                    if (!map.get(ch).equals(word)) return false; // Mismatch
//        }
//        }
