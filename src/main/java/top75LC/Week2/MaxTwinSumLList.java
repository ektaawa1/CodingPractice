package top75LC.Week2;
// 2 pointers' approach with Reverse LL from the middle

import java.util.ArrayList;
import java.util.List;

/**
 * Find the middle of the linked list using the slow/fast pointer method.
 * Reverse the second half of the list.
 * Traverse both halves in parallel, calculating twin sums.
 * Return the maximum twin sum.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MaxTwinSumLList {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //find the middle node
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half linked list
        ListNode reversed = reverseList(slow);

        //Find Max sum
        int maxSum = 0;
        ListNode firstHalf = head;
        while(reversed != null){
            int currSum = firstHalf.val + reversed.val;
            maxSum = Math.max(currSum, maxSum);

            firstHalf = firstHalf.next;
            reversed = reversed.next;
        }
        return maxSum;
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //naive solution using ArrayList for storing LL values and then finding the maxsum
    // using 2 pointers approach with O(n) SC
    public int pairSum1(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Step 1: Store all values into a list
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        int max = 0;
        int n = vals.size();

        // Step 2: Two-pointer approach
        for (int i = 0; i < n / 2; i++) {
            int sum = vals.get(i) + vals.get(n - 1 - i);
            max = Math.max(max, sum);
        }

        return max;
    }
}
//TC = O(n)
//SC = O(1)
/**
 * Dry Run Example:
 * Input: head = [4,2,2,3]
 * Step-by-step:
 * Middle found at value: 2 (2nd index)
 * Reversed second half: 3 -> 2
 * Now traverse first half 4 -> 2 and second half 3 -> 2
 * Twin Sums:
 * 4 + 3 = 7
 * 2 + 2 = 4
 * Return max = 7
 */

/**
 * Reason for using n/2
 * Let’s say n = 6 and the list is: [1, 2, 3, 4, 5, 6]
 * Twin pairs would be: 1 + 6 (i = 0), 2 + 5 (i = 1), 3 + 4 (i = 2)
 *
 * These are n/2 = 3 pairs, so you only need to loop from i = 0 to i < n/2.
 *
 * Each pair involves two nodes:
 * One from the front (i)
 * One from the back (n - 1 - i)
 * So looping n times would duplicate the work. You only need to loop halfway to
 * cover all distinct twin pairs.
 * Think of it like folding a list.
 */
