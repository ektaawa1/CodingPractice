package top75LC.Week2;

import java.util.Arrays;

public class StringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        //calculating the frequency
        for(char ch : word1.toCharArray()){
            freq1[ch - 'a']++;
        }
        for(char ch : word2.toCharArray()){
            freq2[ch - 'a']++;
        }

        for(int i = 0; i<26; i++){
            if((freq1[i] == 0 && freq2[i]!=0) || (freq1[i] != 0 && freq2[i] == 0)){
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public boolean closeStrings1(String word1, String word2) { // word1 = "aab", word2 = "bba"
        if(word1.length() != word2.length()){
            return false;
        }

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        //calculating the frequency
        for(char ch : word1.toCharArray()){
            freq1[ch - 'a']++; // [2,1]
        }
        for(char ch : word2.toCharArray()){
            freq2[ch - 'a']++; // [2,1]
        }
        // checks if characters are same in both the strings
        // Both words use only {a, b} → pass.
        for(int i = 0; i<26; i++){
            if((freq1[i] == 0 && freq2[i]!=0) || (freq1[i] != 0 && freq2[i] == 0)){
                return false;
            }
        }
        //❌ Example (negative):
        //word1 = "abc", word2 = "abz"
        //At index for 'c': freq1=1, freq2=0 → fails.
        //At index for 'z': freq1=0, freq2=1 → fails.

        Arrays.sort(freq1); //[1,2]
        Arrays.sort(freq2); //[1,2]

        for(int i = 0; i<26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
}

// TC = O(n + 26 log 26) → ~O(n), since we count chars and sort arrays of size 26.
// SC = O(26
