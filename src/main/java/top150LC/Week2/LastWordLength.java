package org.Week2;

// 58. Length of Last Word
public class LastWordLength {
    public int lengthOfLastWord(String s) {
        int l = s.length() - 1;

        // Skip all the trailing spaces if any.
        while (l >= 0 && s.charAt(l) == ' ') {
            l--;
        }

        // Initialize index 'startIndex' to keep track of the start of the last word.
        int st = l;

        // Move 'startIndex' backwards until we find a space or reach the beginning of the string.
        while (st >= 0 && s.charAt(st) != ' ') {
            st--;
        }

        // The length of the last word is the difference between 'endIndex' and 'startIndex'.
        // We add 1 because 'startIndex' is either pointing to a space or one position off the string.
        return l - st;
    }
}

//TC = O(n)
//SC = O(1)
