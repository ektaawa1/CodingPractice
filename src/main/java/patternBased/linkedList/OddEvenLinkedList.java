package patternBased.linkedList;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together
 * followed by the nodes with even indices, and return the reordered list.
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 *
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 */

public class OddEvenLinkedList {
    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;  // store start of even list

        while (even != null && even.next != null) {
            odd.next = even.next;    // link to next odd
            odd = odd.next;

            even.next = odd.next;    // link to next even
            even = even.next;
        }

        odd.next = evenHead;  // connect end of odd list to start of even list
        return head;
    }
}
//Time: O(n) – each node visited once
//
//Space: O(1) – no extra data structures
/**
 * Dry Run:
 * Input: head = [1,2,3,4,5]
 * odd point to 1 and even points to 2
 * evenHead points to 2
 *
 * Now odd.next = even.next links 1 to 3
 * then odd = odd.next i.e, now odd points to 3
 *
 * Now even.next = odd.next links 2 to 4
 * then even = even.next i.e., now even points to 4
 *
 * Similarly, 3 links to 5 and now odd points to 5.
 * Similarly, 4 links to null and now even points to null so loop ends.
 *
 * Now, odd.next= evenHead links 5 to 2, so output becomes
 * 1-3-5-2-4-null
 * return head which is 1.
 */