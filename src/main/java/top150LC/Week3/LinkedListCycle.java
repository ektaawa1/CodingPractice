package top150LC.Week3;

import java.util.HashSet;
import java.util.Set;

// https://algo.monster/liteproblems/141
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) {
        val = x;
        next = null;
    }
}
// 2 pointers aproach- slow & fast (Floyd's Tortoise and Hare Algo)
public class LinkedListCycle {
    public boolean hasCycle(ListNode1 head) {
// Initialize two pointers, the slow pointer moves one step at a time.
        ListNode1 slow = head;
        // The fast pointer moves two steps at a time.
        ListNode1 fast = head;

        // Keep traversing the list as long as the fast pointer and its next are not null.
        while (fast != null && fast.next != null) {
            // Move the slow pointer one step.
            slow = slow.next;
            // Move the fast pointer two steps.
            fast = fast.next.next;

            // If the slow and fast pointers meet, a cycle exists.
            if (slow == fast) {
                return true;
            }
        }
        // If the loop ends without the pointers meeting, there is no cycle.
        return false;
    }
    // Using Hashset but this will lead to O(n) SC.
    public boolean hasCycle1(ListNode1 head) {
        Set<ListNode1> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head)) {
                return true; // cycle detected
            }
            visited.add(head);
            head = head.next;
        }

        return false; // no cycle
    }
}
//TC =O(n)
//SC =O(1)
