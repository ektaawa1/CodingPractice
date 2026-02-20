package patternBased.binarySearch.binarySearchOnAnswer;

import java.util.List;
import java.util.stream.Collectors;

//Applying binary search on answer
// Answer is min speed which means my left & right pointers should be speed

/**
 * If speed works → try smaller speed
 * If speed doesn't work → try bigger speed
 * Small k → More time → Might fail
 * Large k → Less time → Will succeed
 * k: 1 2 3 4 5 6 7 8 9 ...
 *    F F F T T T T T T ...
 *    We want First True i.e., minimum k
 */
public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; //as speed can't be 0 here
        int right = 0; //we have to find the max speed from the piles

        // Find max pile (upper bound for speed)
        for (int p : piles) {
            right = Math.max(right, p);
        }

        while (left < right) {
            int midSpeed = left + (right - left) / 2;

            if (canFinish(piles, h, midSpeed)) {
                right = midSpeed; //try smaller speed as we have to find 1st TRUE
            } else {
                left = midSpeed + 1;
            }
        }
        return left;
    }
    private boolean canFinish(int[] piles, int h, int speed) {
        //speed = dist/time
        int hours = 0;
        for (int pile : piles) {
            // hours += ceil(pile / k)
            hours += Math.ceilDiv(pile,speed); //If Java 9 otherwise use (pile + speed - 1) / speed
        }
        return hours <= h;
    }
    //Java 8 streams practise
    public List<Integer> maxSumArray(List<Integer> input) {
        return input.stream().filter(s->s%2==0).map(s->s*s).sorted().collect(Collectors.toList());
    }
}
//  Time complexity = O(n log M) where
//  M is the maximum bananas from the piles and n is the no. of piles ---> MaxPile
//  Space complexity is O(1).

/**
 * Note- In Java, 7/3 = 2.333 and it rounds down to 2 but in our case-
 * koko can't eat half pile, she has to finish all the bananas in the pile,
 * so 7/3 should be 3 for us & not 2.
 * This we can get by implementing the ceil function ceil(7/3)
 * How to implement ceiling division without floating-point?
 * We want this- ceil(pile / speed) we use this trick to get the integer division-
 * ceil(a / b) = (a + b - 1) / b   // integer division
 *
 * Example: pile = 7, speed = 3 → (7 + 3 - 1) / 3 = 9 / 3 = 3 ✅
 * pile = 6, speed = 3 → (6 + 3 - 1) / 3 = 8 / 3 = 2 ✅
 *
 * So the formula:
 * totalHours += (pile + midSpeed - 1) / midSpeed;
 * ensures we always round UP the hours if there’s any remainder.
 */

/**
 * Because integer division in Java floors the result, but we need ceiling.
 * For example, 7 bananas at speed 3 requires 3 hours, not 2.
 * To implement ceiling division without using floats, we use the trick hours += ceil(pile / k)
 * That way, we always round up when there’s a remainder.
 * time = work / rate
 * must round up because you can’t do partial work in less time
 */
