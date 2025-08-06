package top150LC.Week6;

import java.util.HashMap;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> stMap = new HashMap<>();
        HashMap<Character,Character> tsMap = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            char ch1 = t.charAt(i);
            if(stMap.containsKey(ch) && stMap.get(ch) != ch1) return false;
            if(tsMap.containsKey(ch1) && tsMap.get(ch1) != ch) return false;
            stMap.put(ch,ch1);
            tsMap.put(ch1,ch);
        }
        return true;
    }
}

/**
 * Time Complexity: O(n)
 * You iterate once over both strings of length n
 *
 * All HashMap operations (put, get, containsKey) take O(1) average time
 *
 * So total = O(n) time
 *
 * space used is O(n) in total
 *
 * 💡 If strings contain only lowercase letters (like 'a' to 'z'), then
 * space is bounded by a constant (26), and space becomes O(1).
 * But in general case, assume O(n).
 */