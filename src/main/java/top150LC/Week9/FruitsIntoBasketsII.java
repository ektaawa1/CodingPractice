package top150LC.Week9;
// 3477. Fruits Into Baskets II

/**
 * Input: fruits = [4,2,5], baskets = [3,5,4], Output: 1
 * Explanation:
 *
 * fruits[0] = 4 is placed in baskets[1] = 5.
 * fruits[1] = 2 is placed in baskets[0] = 3.
 * fruits[2] = 5 cannot be placed in baskets[2] = 4.
 * Since one fruit type remains unplaced, we return 1.
 *
 * Input: fruits = [3,6,1], baskets = [6,4,7], Output: 0
 * Explanation:
 *
 * fruits[0] = 3 is placed in baskets[0] = 6.
 * fruits[1] = 6 cannot be placed in baskets[1] = 4 (insufficient capacity) but can be placed in the next available basket, baskets[2] = 7.
 * fruits[2] = 1 is placed in baskets[1] = 4.
 * Since all fruits are successfully placed, we return 0.
 */
public class FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        //basket[i] -> container capacity
        //i have to place each element from fruits[] into the basket[]
        //such that the basket can hold that fruit.
        //Return the count of elements that couldn't be placed in the basket.
        int allotted = 0;
        for(int i = 0; i<fruits.length; i++){
            for(int j = 0; j<baskets.length; j++){
                if(fruits[i] <= baskets[j]){ //They place fruit in the first valid basket they encounter i.e why
                    // 4 is stored in capacity 5 since its encountered 1st
                    allotted++;
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return fruits.length-allotted;
    }
}

//TC = O(n^2)
