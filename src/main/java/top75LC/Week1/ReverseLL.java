package top75LC.Week1;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class ReverseLL {
    // 3 pointers approach, TC = O(n), SC = O(1)
    // Input: 1-->2-->3-->4-->5-->null
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while(curr != null){
            next = curr.next;//before breaking the connection
            //now break the connection and make it point to left side to reverse
            curr.next = prev;
            //now update prev & curr values
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
