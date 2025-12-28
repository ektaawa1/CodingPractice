package top150LC.Week4;

// Using Dynamic Programming technique
// Fibonacci Series solution

/**
 * You’re looping n - 1 times because:
 * The first two steps (0 and 1) are already initialized (b = 1, a = 1)
 * So, you only need to compute from step 2 to step n, which is n - 1 iteration
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int a =1; // ways to reach step 1
        int b =1; // ways to reach step 0 (base case)
        for (int i = 0; i<n-1; i++){
            int temp = a;
            a = a+b;
            b = temp;
        }
        return a;
    }
}
//0,1,1,2,3,5,8,13.....

//TC = O(n)
//SC = O(1)

/**
 * While recursion is intuitive and helps define the problem in terms of subproblems,
 * it has exponential time complexity (O(2ⁿ)) due to overlapping subproblems (Repeats subproblems). SC = O(n) → due to call stack.
 * I chose a bottom-up dynamic programming approach with two variables instead, which:
 * Avoids recursion stack overhead
 * Runs in linear time
 * Uses only constant space
 * This is the most efficient and scalable solution, especially for large input sizes.
 */

//public int climbStairs(int n) {
//    if (n <= 2) return n;
//    return climbStairs(n - 1) + climbStairs(n - 2);
//}
