package top150LC.Week6;

import java.util.HashMap;

public class RansomNote {
    //if upper & lowercase letters are part of the input?
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> charMap = new HashMap<>(); // frequency map
        // Count characters in magazine
        for(char ch : magazine.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);
        }
        // Check against ransomNote
        for(char ch: ransomNote.toCharArray()){
            if(! charMap.containsKey(ch) || charMap.get(ch) == 0){
                return false; // Not enough of this char
            }
            charMap.put(ch, charMap.get(ch)-1); //Use one occurrence
        }
        return true;
    }
    // if its specified that only lower case letters are in the input.
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] freq = new int[26]; // only lowercase letters

        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (freq[c - 'a'] == 0) return false;
            freq[c - 'a']--;
        }

        return true;
    }
}

/**
 * Time: O(n + m)
 * n = length of the ransomNote string, m = length of the magazine string
 * Space:
 * O(1) for array solution (since it's fixed 26 lowercase letters)
 * O(k) for HashMap solution (where k is number of unique characters in magazine)
 */

/**
 * I used a HashMap to keep the solution generic and adaptable to any character set.
 * If I knew the input was always lowercase letters a–z, I could optimize this further using a
 * fixed-size int array of 26.
 */