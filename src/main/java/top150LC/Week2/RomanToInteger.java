package top150LC.Week2;

import java.util.HashMap;

// ???????????????????????                            DO IT AGAIN                       ??????????????????
public class RomanToInteger {
    public int romanToInt(String s) {
        int r = 0;
        int prevVal = 0;
        HashMap<Character, Integer> romanMap= new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        for(int i = s.length()-1; i>= 0; i--){
            int currVal = romanMap.get(s.charAt(i));

            if(currVal < prevVal){
                r -= currVal;
            }else{
                r += currVal;
            }
            prevVal = currVal;
        }
        return r;
    }
}

//TC = O(n)
//SC = O(1)