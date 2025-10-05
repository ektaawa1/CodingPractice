package top100Liked;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * Do not modify the linked list.
 */

/**
 * Detect cycle using Floyd’s Tortoise and Hare algorithm.
 * After detection, start one pointer from head and one from meeting point.
 * Move both one step at a time until they meet → that node is the cycle start.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                // ListNode prev = head;
                while(prev != slow){
                    prev = prev.next;
                    slow = slow.next;
                }
                return prev;
            }
        }
        return null;
    }
}
//TC = O(n)
//SC = O(1)
/**
 * When slow == fast, they’ve just met somewhere inside the cycle.
 * But that “meeting point” could be any node in the cycle, not necessarily the one where the cycle begins.
 * 👉 Example:
 * 1 → 2 → 3 → 4 → 5
 *         ↑       ↓
 *         ← ← ← ←
 * Cycle starts at node 3.
 * If you run Floyd’s algorithm:
 * slow and fast might meet at node 4 (or 5, depending on speed).
 * At that point, slow.next = 5.
 * But the real cycle start is node 3 → not slow.next.
 * So slow.next does not always give the cycle entry.
 *
 * Why the head+meeting trick works
 * After they meet:
 * Distance from head → start of cycle = a
 * Distance from start → meeting point = b
 * Cycle length = c
 * From the math of the algorithm: a = c - b
 * Meaning: if you start one pointer at head and another at the meeting point, moving both one step at a time, they’ll meet exactly at the cycle start.
 */
