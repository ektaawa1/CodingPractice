package top150LC.Week6;

import java.util.HashSet;

/**
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1) {
            n = calNewNum(n);
            if(seen.contains(n)){
                return false;
            }
            seen.add(n);
        }
        return true;
    }
    public boolean isHappy1(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            seen.add(n);
            n = calNewNum(n);
            if (n == 1){
                return true;
            }
        }
        return false;
    }
    private int calNewNum(int n){
        int sum = 0;
        while(n>0){
            int a = n% 10;
            sum = sum + a*a;
            n = n/10;
        }
        return sum;
    }
    // Better Solution: Solve using slow & fast pointer as well
    //The idea is: A happy number eventually reaches 1.
    //An unhappy number ends up in a loop (like 4 → 16 → 37 → … → 4).
    public boolean isHappy2(int n){
        int slow = n;
        int fast = calNewNum(n);

        while (fast != 1 && slow != fast) {
            slow = calNewNum(slow);
            fast = calNewNum(calNewNum(fast));
        }

        return fast == 1;
    }
    //Time: O(log n) × C
    //(C is the number of steps until cycle or 1 is detected; log n due to digit sum)
    //
    //Space: O(1) — no extra storage like HashSet.
}

/**
 * Example 1: Input: n = 19, Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * Example 2: Input: n = 2, Output: false
 */

/**
 * slow moves 1 step at a time: slow = calNewNum(slow)
 * fast moves 2 steps at a time: fast = calNewNum(calNewNum(fast))
 *
 * If fast == 1, we found a happy number
 * If slow == fast (but not 1), there’s a cycle
 */
