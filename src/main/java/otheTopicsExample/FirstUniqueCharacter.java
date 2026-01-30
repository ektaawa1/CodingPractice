package otheTopicsExample;

import java.util.HashMap;

/**
 * Given a string s, find the first non-repeating character in it and
 * return its index. If it does not exist, return -1.
 */
public class FirstUniqueCharacter {
    //HashMap only if alphabet is unknown or very large (UTF-8, Unicode)
    // Not that optimal, low performance O(n) time, O(n) space
    // I would use a HashMap to count frequencies and then iterate the array again to find the first element with frequency one.
    // If order must be preserved in one pass, I can use LinkedHashMap.
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(Character c : s.toCharArray()){// HashMap key is an Object so using Wrapper class of primitive type char
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }

        for(int i = 0; i<s.length(); i++){
            if(freqMap.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }
    // Optimal Solution-Using Freq Array of size 26, fastest possible lookup O(n) time, O(1) space
    public int firstUniqChar1(String s) {
        int[] freqArr = new int[26];

        //count each character
        for(char c : s.toCharArray()){ // use primitive type since its an array
            freqArr[c - 'a']++;
        }

        for(int i = 0; i< s.length(); i++){
            if(freqArr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}

/**
 * s.charAt(0) -> l
 * freqArr['l' - 'a'] → freqArr[11] = 1
 *
 * freq[0] = count of 'a', freq[1] = count of 'b'
 * …
 * freq[25] = count of 'z'
 */