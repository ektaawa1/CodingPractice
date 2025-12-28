package otheTopicsExample;

/**
 * Given a singly linked list containing only 0, 1, and 2, sort it so that all 0s come first, then 1s, then 2s.
 * Input:  1 → 2 → 0 → 1 → 2 → 0
 * Output: 0 → 0 → 1 → 1 → 2 → 2
 */
public class SortLL{
    public ListNode sortList(ListNode head) {
        int count0 = 0, count1 = 0, count2 = 0;
        ListNode curr = head;

        // First pass: count values
        while (curr != null) {
            if (curr.val == 0) count0++;
            else if (curr.val == 1) count1++;
            else count2++;
            curr = curr.next;
        }

        // Second pass: overwrite values
        curr = head;
        while (count0-- > 0) {
            curr.val = 0;
            curr = curr.next;
        }
        while (count1-- > 0) {
            curr.val = 1;
            curr = curr.next;
        }
        while (count2-- > 0) {
            curr.val = 2;
            curr = curr.next;
        }

        return head;
    }
    //If changing the values is not allowed
    public ListNode sortList1(ListNode head) {
        ListNode zeroD = new ListNode(0);
        ListNode oneD = new ListNode(0);
        ListNode twoD = new ListNode(0);

        ListNode zero = zeroD, one = oneD, two = twoD;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.val == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // connect lists
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;

        return zeroD.next;
    }
}
//Time: O(n)
//Space: O(1)

/**
 * zeroD → 0 → null
 * oneD  → 1 → 1 → null
 * twoD  → 2 → 2 → null
 * zero.next = (oneD.next != null) ? oneD.next : twoD.next;
 * one.next = twoD.next;
 * two.next = null;
 */
