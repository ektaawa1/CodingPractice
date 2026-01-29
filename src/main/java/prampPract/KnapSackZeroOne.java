package prampPract;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a function for the 0/1 Knapsack problem. Given a set of items,
 * each with a weight and a value, determine the number of each item to include in a
 * collection so that the total weight is less than or equal to a given limit and
 * the total value is as large as possible. The solution should not exceed the knapsack's maximum capacity, C.
 */
public class KnapSackZeroOne {

    public static int knapsack(int[] weight, int[] values, int cap) {
        return knapsackHelper(weight, values, cap, 0, new HashMap<>());
    }

    private static int knapsackHelper(int[] weights, int[] values, int capacity, int i, Map<String, Integer> mapMemo){
        //Base Case
        if(i == weights.length || capacity <= 0){
            return 0;
        }
        String key = i + "-" + capacity;

        if(mapMemo.containsKey(key)){
            return mapMemo.get(key);
        }

        //exclude the current item
        int exclude = knapsackHelper(weights, values, capacity, i+1, mapMemo);

        //include the current item if it fits
        int include = 0;
        if(weights[i] <= capacity){
            include = values[i] + knapsackHelper(weights, values, capacity-weights[i], i+1, mapMemo);
        }

        int output = Math.max(include,exclude);
        mapMemo.put(key, output);

        return output;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        System.out.println("Maximum value in knapsack = " + knapsack(weights, values, capacity));
    }
}
//Note-
//At each item, I have two choices: take it (if it fits) or skip it.
//For recursion, I move to the next item (index+1) in both cases because we can only use each item once.
//I memoize results with a HashMap using index-cap as key, so I don’t recompute subproblems.
//This reduces exponential recursion to O(n × capacity).
//Memoization in simple terms- Remembering the answers to problems you’ve already solved so you don’t solve them again.
//Memoization = the student writing down the answer (24 * 37 = 888) somewhere so next time they don’t repeat the calculation.
//In recursion:
//The program solves a problem by breaking it into smaller subproblems.Sometimes, the same subproblem comes up again.
//If the program remembers the answer (by using hashmap for lookup), it doesn’t compute it again → saves time.

/**
 * Examples-
 * weights = [10, 20, 30]
 * values = [60, 100, 120]
 * capacity = 50
 * output: 220
 *
 * weights = [4, 5, 1]
 * values = [1, 2, 3]
 * capacity = 4
 * output: 3
 *
 * weights = [1, 1, 1]
 * values = [10, 20, 30]
 * capacity = 2
 * output: 50
 */

/**
 * Explanation-
 * At any item index, we have two choices:
 *
 * Case 1- Include current item (if weight fits)
 *
 * Add its value
 *
 * Reduce remaining capacity by weight[index]
 *
 * Move to next item → index + 1
 *
 * Case 2 - Exclude current item
 *
 * Don’t add value
 *
 * Keep capacity the same
 *
 * Move to next item → index + 1
 *
 * Important: index + 1 is correct in both cases because in 0/1 Knapsack each item can only be used once.
 *
 * Step 2: Why We Build the Key?
 *
 * We use a HashMap for memoization to avoid recomputation.
 *
 * Key = "index-capacity"
 *
 * Why both? Because the same index with different remaining capacity is a different subproblem.
 */

/**
 * Example Recursive Tree-
 * Start: index=0, cap=50
 *
 * Include item 0 (weight=10, value=60), remaining cap=40
 *  └─ index=1, cap=40
 *      ├─ Include item 1 (weight=20, value=100), cap=20
 *      │   └─ index=2, cap=20
 *      │       ├─ Include item 2 (weight=30) ❌ (doesn’t fit)
 *      │       └─ Exclude item 2 → value=0
 *      │   Total value = 100 + 0 = 100
 *      │   Add value of item 0 = 60 → total 160
 *      │
 *      └─ Exclude item 1 → index=2, cap=40
 *          ├─ Include item 2 (weight=30, value=120), cap=10
 *          │   └─ index=3, cap=10 → return 0
 *          │   Total = 120 + 0 = 120
 *          │   Add value of item 0 = 60 → total 180
 *          └─ Exclude item 2 → 0 + 60 = 60
 *
 * Best path from including item 0 = **180**
 *
 * Exclude item 0 → index=1, cap=50
 *  ├─ Include item 1 (weight=20, value=100), cap=30
 *  │   └─ index=2, cap=30
 *  │       ├─ Include item 2 (weight=30, value=120), cap=0 → total 120
 *  │       │   Add value of item 1 = 100 → 220 ✅
 *  │       └─ Exclude item 2 → value=100
 *  └─ Exclude item 1 → index=2, cap=50
 *      ├─ Include item 2 (weight=30, value=120) → total 120
 *      └─ Exclude item 2 → 0
 *
 * Best path from excluding item 0 = **220**
 */
