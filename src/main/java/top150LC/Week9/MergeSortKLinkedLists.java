package top150LC.Week9;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
class ListNodeX {
      int val;
    ListNodeX next;
    ListNodeX() {}
    ListNodeX(int val) { this.val = val; }
    ListNodeX(int val, ListNodeX next) { this.val = val; this.next = next; }
  }
public class MergeSortKLinkedLists {
    //Using Divide & Conquer
    public ListNodeX mergeKLists(ListNodeX[] lists) {
        if(lists == null || lists.length == 0) return null;

        return mergeSort(lists, 0, lists.length-1);
    }
    private ListNodeX mergeSort(ListNodeX[] lists, int left, int right) {
        if (left == right) return lists[left];   // only one list

        int mid = left + (right - left)/2;
        ListNodeX l1 = mergeSort(lists, left, mid);
        ListNodeX l2 = mergeSort(lists, mid+1, right);
        return mergeTwoLists(l1, l2);
    }
    private ListNodeX mergeTwoLists(ListNodeX l1, ListNodeX l2) {
        ListNodeX dummy = new ListNodeX(0);
        ListNodeX tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        // Attach remaining nodes
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }
}
