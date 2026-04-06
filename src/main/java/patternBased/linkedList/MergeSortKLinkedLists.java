package patternBased.linkedList;

import java.util.PriorityQueue;

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
    //Using Divide & Conquer- SC is O(log K) (recursion stack)
    //If K is massive, the overhead of the Priority Queue might be high. We could use a Divide and Conquer approach,
    // where we merge pairs of lists recursively. This also has O(N log K) TC
    // but can be easier to parallelize in a distributed environment.
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
    //another solution, TC = O(N log K) and SC = O(K)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // 1. Min-Heap with a Comparator (as we discussed)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 2. Add the head of each list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        // 3. Use a dummy node to build the result list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            // Get the smallest node
            ListNode smallest = minHeap.poll();
            curr.next = smallest;
            curr = curr.next;

            // If this list has more nodes, add the next one to the heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}

/**
 * I can solve this using two main approaches.
 * The most intuitive way is using a Min-Heap, which gives us O(N log K) time and O(K) space.
 * It’s very efficient for 'streaming' data.Alternatively, I can use a Divide and Conquer approach,
 * similar to Merge Sort. We merge pairs of lists recursively.
 * This also gives us O(N log K) time, but it reduces the auxiliary space to O(log K) for the recursion stack.
 */
