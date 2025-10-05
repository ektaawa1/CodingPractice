package top150LC.Week3;

// 2. Add Two Numbers
// Linked List https://algo.monster/liteproblems/2
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);//will point to the head of the result linked list
        ListNode curr = dummy; //will point to the current node in the new Linked list

        int carry = 0; //to keep track of carry-over
         while(l1 != null || l2 != null || carry != 0){
             //handling the case where l1 or l2 has no node left so we treat it as 0
             int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry; //calculate sum

             curr.next = new ListNode(sum % 10); // store the digit value of sum in a new node
             curr = curr.next; // moves to the new node you just added

             carry = sum / 10;

             // handling the case where l1 or l2 has no node left
             l1 = l1 == null? null : l1.next;
             l2 = l2 == null? null : l2.next;
         }
         return dummy.next;
    }
}

//Example-
/**
 * sum = 7
 * curr.next = new ListNode(7);  // curr.next points to new node 7
 * curr = curr.next;            // curr moves to node 7
 *
 * Next sum = 0
 * curr.next = new ListNode(0); // curr.next points to new node 0
 * curr = curr.next;            // curr moves to node 0
 *
 * Next sum = 8
 * curr.next = new ListNode(8); // curr.next points to new node 8
 * curr = curr.next;            // curr moves to node 8
 */

//| Metric    | Complexity                                  |
//| --------- | ------------------------------------------- |
//| **Time**  | O(max(m, n)) (m = l1 length, n = l2 length) |
//| **Space** | O(max(m, n)) — for result list              |
