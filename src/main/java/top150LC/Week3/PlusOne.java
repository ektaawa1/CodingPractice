package top150LC.Week3;

//

/**
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Input: digits = [9]
 * Output: [1,0]
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int len= digits.length-1;
        while (carry != 0){
            if(digits[len]+ carry != 10){  // No carry-over
                digits[len] += carry;
                carry = 0;
            }
            else {
                digits[len] = 0; // Set current to 0 and carry 1 to the left
            }
            len--;
            // this part only runs if all the digits are 9.
            if(len < 0 && carry !=0){
                int arr[] = new int[digits.length+1];
                arr[0] = 1; // First digit is 1, rest are 0 by default
                return arr;
            }
        }
        return digits;
    }
    // using for loop
    public int[] plusOne1(int[] digits) {
        int len = digits.length - 1;

        for(int i = len; i >= 0; i--) {
            if(digits[i] < 9) { // No carry-over
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // Set current to 0 and carry 1 to the left
        }

        // If all digits were 9
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1; // First digit is 1, rest are 0 by default
        return newNumber;
    }
}
//TC = O(n)
//SC = O(n)
// This performs in O(n) time and O(1) space unless reallocation is required.
