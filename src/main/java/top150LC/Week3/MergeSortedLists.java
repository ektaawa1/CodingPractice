package top150LC.Week3;

//21. Merge Two Sorted Lists
// https://algo.monster/liteproblems/21
class ListNode2 {
      int val;
      ListNode2 next;
      ListNode2() {}
      ListNode2(int val) { this.val = val; }
      ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}
public class MergeSortedLists {
    public ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {
        ListNode2 dummy = new ListNode2(-1);
        ListNode2 curr = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        // or replace with this curr.next = (list1 == null) ? list2 : list1;
        if(list1 != null){
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        return dummy.next;
    }
}

//TC = O(n+m)
//SC = O(1)
