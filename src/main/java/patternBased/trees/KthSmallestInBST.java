package patternBased.trees;

import java.util.PriorityQueue;

/**
 * For BST:
 * Inorder > Heap
 * For general BT:
 * Heap > Inorder
 */
class TreeNodeBst {
      int val;
      TreeNodeBst left;
      TreeNodeBst right;
      TreeNodeBst() {}
      TreeNodeBst(int val) { this.val = val; }
      TreeNodeBst(int val, TreeNodeBst left, TreeNodeBst right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

/**
 * In-order traversal approach
 * Use the Property:
 * Inorder traversal of BST gives increasing sorted order. (Left, Root, Right)
 * So:
 * Do inorder
 * Stop at kth element
 */
public class KthSmallestInBST {
    private int count;
    private int ans;
    public int kthSmallest(TreeNodeBst root, int k) {
        this.count = k;
        inorderTraversal(root);
        return ans;
    }
    private void inorderTraversal(TreeNodeBst node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);//traverse left
        count--;
        if(count == 0){
            ans = node.val;
            return;
        }
        inorderTraversal(node.right);//traverse right
    }
    //alternate approach
    public int kthSmallestUsingMaxHeap(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        dfsMaxHeap(root, k, maxHeap);

        return maxHeap.peek();
    }
    private void dfsMaxHeap(TreeNode node, int k, PriorityQueue<Integer> heap) {
        if (node == null) return;

        heap.offer(node.val);

        if (heap.size() > k) {
            heap.poll();
        }

        dfsMaxHeap(node.left, k, heap);
        dfsMaxHeap(node.right, k, heap);
    }
}
//Time complexity (average): O(H + k),
//where H is the tree height (log n for balanced BST, n for skewed).
//
//Space complexity: O(H) recursion stack
/**
 * What does the Max Heap solution look like?
 * Logic
 * Traverse entire tree (any traversal)
 * Push values into maxHeap
 * If size > k → poll()
 * At end → heap.peek() = kth smallest
 */

/**
 * Efficiency Comparison
 * Approach	Time Complexity	Space Complexity	Comment
 * In-order traversal	O(H + k) (best), O(n) (worst)	O(H) (recursion stack)	✅ Most optimal for BSTs
 * Min Heap	O(n + k log n)	O(n) (heap)	❌ Inefficient for large trees
 */
