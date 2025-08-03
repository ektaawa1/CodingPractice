package top75LC.Week1;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while(even != null && even.next != null){//odd will always be behind even so checking just for even condition
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
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