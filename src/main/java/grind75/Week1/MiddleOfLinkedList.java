package grind75.Week1;
// 876. Middle of the Linked List
/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // Using Counting method
    public ListNode middleNode1(ListNode head) {
        int count = 0;
        ListNode temp = head;

        // 1️⃣ Count total nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // 2️⃣ Traverse to middle
        int middleIndex = count / 2;
        temp = head;
        for (int i = 0; i < middleIndex; i++) {
            temp = temp.next;
        }

        return temp;
    }
}

/**
 * Why it works:
 * fast moves twice as fast, so slow is always at half the distance.
 * Time: O(n) → traverse the list once
 *
 * Space: O(1) → only two pointers
 */

/**
 * Counting Method (Less Optimal)
 * Idea:
 * Traverse the linked list to count the total number of nodes (n).
 * Traverse again to reach the n/2-th node (0-based index) → this is the middle.
 * Time: O(n) + O(n) = O(2n) → simplified to O(n)
 * Space: O(1)
 */
