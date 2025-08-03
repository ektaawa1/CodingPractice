package top75LC.Week1;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int val) {
        this.val = val;
    }
}
public class ReverseLLRecursion {
    //recursion approach, TC = O(n), SC = O(n) call stack- more elegant, but risk of stack overflow.
    public static ListNode1 reverseListRecursion(ListNode1 head) {
        //base case
        if(head == null || head.next == null){
            return head;
        }
        ListNode1 newHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    // Helper method to print list
    public static void printList(ListNode1 head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Build list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);

        System.out.println("Original List:");
        printList(head);

        ListNode1 reversedHead = reverseListRecursion(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
    }
}
