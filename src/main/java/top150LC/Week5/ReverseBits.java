package org.Week5;

/**
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the
 * unsigned integer 43261596, so return 964176192 which its binary representation is
 * 00111001011110000010100101000000.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0;i<32;i++){
            //extract last bit from the given number n
            int lastBit = n & 1;
            // update the result by adding lastBit, but 1st shift the bits
            // to left by 1 so that new bit can be added
            result = (result<<1) | lastBit;
            //update n by discarding the last bit already used so that in the next iteration
            // new bit will be extracted to be used.
            n = n>>>1;
        }
        return result;
    }
}

/**
 * Summary-
 * ✅ Extract the last bit from `n`
 * ✅ Shift `result` left and insert the last bit
 * ✅ Unsigned right shift to discard used bit
 */

/**
 * Dry Run- for n = 6 (000...0110)
 *
 * int result = 0;
 *
 * Loop 1:
 * lastBit = 6 & 1 = 0
 * result = 0 << 1 | 0 = 0
 * n = 6 >>> 1 = 3 (000...0011)
 *
 * Loop 2:
 * lastBit = 3 & 1 = 1
 * result = 0 << 1 | 1 = 1
 * n = 3 >>> 1 = 1 (000...0001)
 *
 * Loop 3:
 * lastBit = 1 & 1 = 1
 * result = 1 << 1 | 1 = 3
 * n = 1 >>> 1 = 0
 *
 * After 3 steps:
 * n = 0, loop continues for remaining 29 iterations (adding 0s)
 * Final result becomes 1100...0000 (reversed)
 */

/**
 * In Plain English
 * n & 1 → Get the last bit of n
 * result << 1 | lastBit → Shift result left and attach the bit from n
 * n >>> 1 → Discard the last bit of n, move to next bit
 */
