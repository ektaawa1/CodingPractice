package patternBased.slidingWindow;

//Permutation In String

import java.util.Arrays;
import java.util.HashMap;

/**
 * Bruteforce-
 * generating all permutations of s1 is a brute-force approach that will lead to a Time Limit Exceeded (TLE) error.
 * The number of permutations of a string of length n is n!.
 * If s1 has a length of 10, that is over 3.6 million combinations to check against s2!
 */
public class PermutationInString {
    //TC = O(n1+n2), SC = O(n)
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()){
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2){
            return false;
        }
        HashMap<Character, Integer> freqMap = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        for(int i = 0; i<n1; i++){
            freqMap.put(s1.charAt(i), freqMap.getOrDefault(s1.charAt(i),0)+1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i),0)+1);
        }
        if(freqMap.equals(s2Map)){ //expensive way to compare
            return true;
        }

        int left = 0;
        for(int right = n1; right <n2; right++){
            char ch = s2.charAt(right);//we have to add
            s2Map.put(ch, s2Map.getOrDefault(ch,0)+1);

            char chLeft = s2.charAt(left);//we have to remove
            s2Map.put(chLeft, s2Map.get(chLeft)-1);
            if(s2Map.get(chLeft) == 0){
                s2Map.remove(chLeft);
            }
            left++; //slide the window

            if(freqMap.equals(s2Map)){
                return true;
            }
        }
        return false;
    }
    //Optimized Solution- TC = O(n1+n2), SC = O(1)
    public boolean checkInclusionUsingArray(String s1, String s2) {
        if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()){
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] freqArr = new int[26];
        int[] s2FreqArr = new int[26];

        // Fill frequency arrays for s1 and the first window of s2
        for (int i = 0; i < n1; i++) {
            freqArr[s1.charAt(i) - 'a']++;
            s2FreqArr[s2.charAt(i) - 'a']++;
        }

        // Compare the first window: O(1) time complexity
        if (Arrays.equals(freqArr, s2FreqArr)) return true;

        // Slide the window across s2
        for (int right = n1; right < n2; right++) {
            // Add the new character into the window from right side
            s2FreqArr[s2.charAt(right) - 'a']++;
            // Remove the character from left side
            s2FreqArr[s2.charAt(right - n1) - 'a']--;

            // Compare frequencies: O(1) time complexity
            if (Arrays.equals(freqArr, s2FreqArr)) return true;
        }

        return false;
    }
}

/**
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */
