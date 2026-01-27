package top75LC.Week2;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Applying binary search algo
public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;

        // Find max pile (upper bound for speed)
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while (minSpeed < maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            // Calculate total hours at this midSpeed
            int totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + midSpeed - 1) / midSpeed; // ceil division
            }

            if (totalHours > h) {
                // too slow → need higher speed
                minSpeed = midSpeed + 1;
            } else {
                // can finish on time or earlier → try smaller speed
                maxSpeed = midSpeed;
            }
        }

        return minSpeed; // minSpeed == maxSpeed here
    }
    public List<Integer> maxSumArray(List<Integer> input) {
        return input.stream().filter(s->s%2==0).map(s->s*s).sorted().collect(Collectors.toList());
    }
}
//  Time complexity = O(n log M) where
//  M is the maximum bananas from the piles and n is the no. of piles, Space complexity is O(1).

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
 * To implement ceiling division without using floats, we use the trick (a + b - 1) / b.
 * That way, we always round up when there’s a remainder.
 * time = work / rate
 * must round up because you can’t do partial work in less time
 */
