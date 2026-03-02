package patternBased.heap;

import java.util.PriorityQueue;

class ListNodeAB {
      int val;
    ListNodeAB next;
    ListNodeAB() {}
    ListNodeAB(int val) { this.val = val; }
    ListNodeAB(int val, ListNodeAB next) { this.val = val; this.next = next; }
  }
public class MergeKSortedLists {
    //prefer this solution
    public ListNodeAB mergeKLists(ListNodeAB[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        //Put all nodes into an array/list, sort them, and rebuild the linked list.
        //Time: O(N log N) where N = total number of nodes.
        //Space: O(N).

        //Optimized Solution: Using MinHeap
        PriorityQueue<ListNodeAB> minHeap = new PriorityQueue<>((a, b)-> a.val - b.val); //Lambda to write the comparator:
        for(ListNodeAB n : lists){
            if(n != null){
                minHeap.offer(n); //adding head of each linked list
            }
        }

        ListNodeAB dummy = new ListNodeAB(0);
        ListNodeAB curr = dummy;

        while(!minHeap.isEmpty()){
            ListNodeAB node = minHeap.poll(); //smallest node as minHeap
            curr.next = node;
            curr = curr.next;
            if(node.next != null){ //to get the next nodes
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }
    //Using Divide & Conquer
    public ListNodeAB mergeKLists1(ListNodeAB[] lists) {
        if(lists == null || lists.length == 0) return null;

        return mergeSort(lists, 0, lists.length-1);
    }
    private ListNodeAB mergeSort(ListNodeAB[] lists, int left, int right) {
        if (left == right) return lists[left];   // only one list

        int mid = left + (right - left)/2;
        ListNodeAB l1 = mergeSort(lists, left, mid);
        ListNodeAB l2 = mergeSort(lists, mid+1, right);
        return mergeTwoLists(l1, l2);
    }
    private ListNodeAB mergeTwoLists(ListNodeAB l1, ListNodeAB l2) {
        ListNodeAB dummy = new ListNodeAB(0);
        ListNodeAB curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // Attach remaining nodes
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }
}
//MinHeap Approach: Time: O(N log k) → N = total nodes, heap operations log k
//Space: O(k) → priority queue size

//Divide & Conquer Approach:
//Time: O(N log k) → N
//Where: N = total number of nodes, K = number of lists
//Space: O(1)

//Example:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]

//So 1st- 1,1,2 will be stored in minHeap
//smallest will be popped out i.e. 1 and 1.next is 4 so minHeap will be 1,2,4 and so on 2,3,4
// then 3,4,6 then 4,4,6 then 4,5,6
//ouput build will be 1->1->2->3->4->5->6

/**
 In Java, PriorityQueue needs to know how to compare elements.
 By default, PriorityQueue works as a min-heap, but only if the elements are comparable (e.g., integers).
 Here, we are storing ListNode objects, not integers.
 ListNode has no default comparison (it doesn’t implement Comparable).
 So, we must tell the heap how to compare two nodes.
 That’s what (a, b) -> a.val - b.val does:
 If a.val < b.val, it returns a negative → a comes before b.
 If a.val > b.val, it returns a positive → b comes before a.
 If equal → returns 0.
 So yes this ensures the smallest node value stays at the top of the heap.
 */
