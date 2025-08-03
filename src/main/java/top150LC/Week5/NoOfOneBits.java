package top150LC.Week5;

public class NoOfOneBits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i<32; i++){
            int lastBit = n & 1;
            if(lastBit == 1){
                count++;
            }
            n = n>>>1;
        }
        return count;
    }
}
/**
 * My Solution-
 * Works even if the number is negative (due to use of >>>)
 * Checks all 32 bits of an integer- 32 iterations
 * Easy to understand and explain in interviews
 * TC = O(1)
 */

