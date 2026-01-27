package patternBased.slidingWIndow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        //longest substring
        //without duplicates so use HashSet
        //variable size window
        //build the substring
        //if character is present in hashset then remove char from left and add it from right
        //if not present, add it in hashset

        if(s.isEmpty() || s.length() == 0){
            return 0;
        }
        HashSet<Character> set1 = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            while(set1.contains(ch)){
                set1.remove(s.charAt(left));
                left++;
            }
            set1.add(ch);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
//TC = O(n)
//SC = O(n)
/**
 right → always moves forward

 left → moves only when invalid

 Window is [left, right]

 Track max length
 */
