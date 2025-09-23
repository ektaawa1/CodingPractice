package top150LC.Week8;

/**
 * Input: head = [4,2,1,3], Output: [1,2,3,4]
 * Input: head = [-1,5,3,4,0], Output: [-1,0,3,4,5]
 */
// Using Merge Sort Algo- Divide & Conquer
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){ // base condition
            return head;
        }
        ListNode mid = midNode(head); // find mid node using slow & fast pointer
        ListNode right = mid.next;
        mid.next = null; // break the ll from mid node

        ListNode leftSide = sortList(head);// divide left part
        ListNode rightSide = sortList(right);// divide right part

        return mergeNodes(leftSide, rightSide);// merge left & right parts
    }

    private ListNode midNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next; // for stack overflow exception
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeNodes(ListNode leftSorted, ListNode rightSorted){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(leftSorted != null && rightSorted != null){
            if(leftSorted.val <= rightSorted.val){
                curr.next = leftSorted;
                leftSorted = leftSorted.next;
            } else {
                curr.next = rightSorted;
                rightSorted = rightSorted.next;
            }
            curr = curr.next;
        }

        if(leftSorted != null) curr.next = leftSorted;
        if(rightSorted != null) curr.next = rightSorted;

        return dummy.next;
    }
}
// Time: O(n log n) → log n splits × n merge steps
//Space: O(1) (if we ignore recursion stack)

/**
 Difference Between Cycle Detection vs Mid for Merge Sort
 Cycle Detection / Length-based problems
 👉 We want slow to land exactly at the cycle entry OR the middle node.
 👉 Starting both at head works fine.

 Merge Sort (Split Linked List into Two Halves)
 👉 Our goal is to cut the list into two halves.
 👉 If we start both slow and fast at head, in the case of even-length lists,
    slow ends up at the right middle, which causes endless recursion (because we never truly shrink the list).

 That’s why we use:

 ListNode slow = head;
 ListNode fast = head.next;
 Example - list = 1 -> 2 -> 3 -> 4 (even size)
 */
