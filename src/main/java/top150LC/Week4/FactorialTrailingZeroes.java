package org.Week4;

// The approach used here is-
//"How many trailing zeros in n!?" → You think:
//        → Trailing zeros come from 10 = 2×5
//        → 2s are abundant, so count the 5s
//→ For that, divide n by powers of 5
//        → Accumulate the total.
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n>= 5){
//            n = n/5;
//            count = count + n;
            n /= 5;
            count += n;
        }
        return count;
    }
}

//Time Complexity:
//O(log₅ n) — because we keep dividing n by 5
//
//No recursion or factorial computation needed
/**
 * Factorials grow extremely fast. For example:
 * 20! = 2.43 × 10^18
 * 100! ≈ 9.33 × 10^157 (157 digits!)
 * For values like n = 5000, computing 5000! is very slow and memory-heavy.
 * Trailing zeroes can be computed without computing the factorial at all — saving time and space.
 */
//Brute Force- Calculate Factorial then calculate trailing 0s.
/**
 * // Step 1: Calculate factorial using BigInteger
 *         BigInteger fact = BigInteger.ONE;
 *         for (int i = 2; i <= n; i++) {
 *             fact = fact.multiply(BigInteger.valueOf(i));
 *         }
 *
 *         // Step 2: Count trailing zeroes in the factorial
 *         int count = 0;
 *         String str = fact.toString();
 *         int len = str.length();
 *
 *         for (int i = len - 1; i >= 0; i--) {
 *             if (str.charAt(i) == '0') {
 *                 count++;
 *             } else {
 *                 break;
 *             }
 *         }
 *
 *         return count;
 */
