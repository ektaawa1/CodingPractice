package org.Week5;

/**
 * Binary Addition-
 * 0 + 0 = 0 → sum: 0, carry: 0
 * 0 + 1 = 1, 1 + 0 = 1 → sum: 1, carry: 0
 * 1 + 1 = 10 → sum: 0, carry: 1
 * 1 + 1 + 1 = 11 → sum: 1, carry: 1
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int l1 = a.length()-1;
        int l2 = b.length()-1;
        int carry = 0;
        while(l1>=0 || l2>=0 || carry !=0){
            int sum = carry;
            if(l1>=0){ //avoid accessing characters that are out of bounds due to unequal length
                sum = sum + a.charAt(l1--) - '0'; //Convert char to int and add
            }
            if(l2>=0){ //avoid accessing characters that are out of bounds due to unequal length
                sum = sum + b.charAt(l2--) - '0'; //Convert char to int and add
            }
            sb.append(sum%2); //Get the current bit to append
            carry = sum / 2; //Update carry for next round
        }
        return sb.reverse().toString();
    }
}

/**
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

/**
 * Why % 2 and / 2?
 * Because we’re working in binary (base 2), we want to:
 * Get the last bit of the binary result:
 * sb.append(sum % 2);  // Either 0 or 1
 * Why?
 * In binary, the last digit of a number is sum % 2
 * If sum = 2 → 2 in binary is 10 → last digit is 0
 * If sum = 3 → 11 → last digit is 1
 */

/**
 * Why check i >= 0 / j >= 0?
 * | Condition                           | Purpose                                       |
 * | ------------------------------------| --------------------------------------------- |
 * | `if (i >= 0)`                       | Prevent accessing `a.charAt(i)` when `i < 0`
 *                                          (i.e., no more characters left in `a`) |
 * | `if (j >= 0)`                       | Same, but for `b.charAt(j)`                   |
 *
 * | ❗ Without these checks, you'd get
 * `StringIndexOutOfBoundsException`      |                                                   |
 */
