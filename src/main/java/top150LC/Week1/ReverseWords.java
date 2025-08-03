package top150LC.Week1;
//????????????????????               DO AGAIN                ??????????????????
//151. Reverse Words in a String
// https://medium.com/@keinn/lc-151-reverse-words-in-a-string-29d27284b519

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include
 * any extra spaces.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

//2 pointers approach
public class ReverseWords {
    public String reverseWords(String s) {
        String arr[] = s.trim().split("\\s+");

        //convert arr to list
        List<String> str_list = new ArrayList<String>(Arrays.asList(arr));

        //reverse the list
        Collections.reverse(str_list);

        //join the words back to form a string
        String str_reversed = String.join(" ", str_list);

        return str_reversed;
    }

    public String reverseWords1(String s){
        String temp = s.trim(); // removes all leading and trailing whitespace characters (spaces, tabs, newlines, etc.)
        String[] arr = temp.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--){ // reverse loop
            String str = arr[i];
            if (str.isBlank()) continue;

            sb.append(str);
            if (i != 0) sb.append(" "); // add space for each character, except the last
        }
        return sb.toString();
    }
}
//TC = O(n)
//SC = O(n)

/**
 * Explanation-
 * Every time you concatenate strings using String, it creates a new String object. This can lead
 * to performance issues, especially in scenarios involving large or numerous string manipulations.
 * A more efficient alternative is to use StringBuilder. StringBuilder is mutable, meaning it
 * allows appending, inserting, or modifying the characters without creating new objects each time.
 * This can significantly improve both time and memory efficiency, as it minimizes the number of
 * temporary objects created and reduces the workload on the garbage collector.
 */
