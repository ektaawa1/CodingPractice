package top150LC.Week4;

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
 */
public class KthSmallestInBST {
    private int k;
    private int ans;
    public int kthSmallest(TreeNodeBst root, int k) {
        this.k = k;
        helper(root);
        return ans;
    }
    private void helper(TreeNodeBst node){
        if(node == null){
            return;
        }
        helper(node.left);
        k--;
        if(k == 0){
            ans = node.val;
            return;
        }
        helper(node.right);
    }
}
//Time complexity (average): O(H + k),
//where H is the tree height (log n for balanced BST, n for skewed).
//
//Space complexity: O(H) recursion stack
/**
 * What does the Min Heap solution look like?
 * Traverse the entire BST (e.g., using DFS or BFS).
 * Add all values to a Min Heap (PriorityQueue).
 * Poll the heap k times to get the k-th smallest.
 */

/**
 * Efficiency Comparison
 * Approach	Time Complexity	Space Complexity	Comment
 * In-order traversal	O(H + k) (best), O(n) (worst)	O(H) (recursion stack)	✅ Most optimal for BSTs
 * Min Heap	O(n + k log n)	O(n) (heap)	❌ Inefficient for large trees
 */
