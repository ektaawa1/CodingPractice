package otheTopicsExample;

/**
 * Given an integer n, return true if and only if it is an Armstrong number.
 * The k-digit number n is an Armstrong number if and only if the kth power of each digit sums to n.
 *
 * Example 1:
 * Input: n = 153
 * Output: true
 * Explanation: 153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
 *
 * Example 2:
 * Input: n = 123
 * Output: false
 * Explanation: 123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.
 *
 */
public class ArmstrongNum {
    public boolean isArmstrong(int n) {
        int sum = 0;
        int num = n;
        int count = 0;
        while(num > 0){
            count++;
            num = num/10;
        }
        int temp = n;
        while(temp>0){
            int a = temp%10;
            sum += (int) Math.pow(a,count);
            temp = temp/10;
        }
        return sum == n;
    }
}
//The time complexity is O(d), where d is the number of digits in the number, which is O(log n).
//The space complexity is O(1) because only constant extra variables are used.
/**
 * | Input | Output |
 * | ----- | ------ |
 * | 2     | true   | 2¹ = 2
 * | 9     | true   | 9¹ = 9
 * | 153   | true   |
 * | 123   | false  |
 */
