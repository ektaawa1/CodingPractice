package top150LC.Week3;

import java.util.Stack;

/**
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 */
public class AddTwoNumbersII {
    //stack approach
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1!=null){
            s1.push(l1.val);//3,4,2,7 LIFO(3 is last)
            l1 = l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);//4,6,5 LIFO(4 is last)
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null; //head insertion logic is used here
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int v1 = !s1.isEmpty()?s1.pop():0;
            int v2 = !s2.isEmpty()?s2.pop():0;

            int sum = v1+v2+carry;
            carry = sum/10;
            ListNode nextNode = new ListNode(sum%10);
            nextNode.next = head;
            head = nextNode;
        }
        return head;
    }
    //If Modification of Input is allowed, Time: O(n), Space: O(1)
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
/**
 3+4 = 7
 so 7->null
 4+6 = 0 and carry 1
 so 0->7->null;
 5+2+1= 8
 so 8->0->7->null
 7+0+0= 7
 so 7 attaches to head i.e. 7->8->0->7->null
 */
//Time: O(n), Space: O(n) (stacks)
