package top150LC.Week7;

//112. Path Sum
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        //check if it's a leaf node
        if(root.left == null && root.right == null && targetSum == root.val){
            return true;
        }
        // Recurse left and right with reduced sum
        return hasPathSum(root.left, targetSum-root.val) ||
                hasPathSum(root.right, targetSum-root.val);
    }
}
//Time Complexity: O(n) → we may visit all nodes in the worst case.
//
//Space Complexity: O(h) → recursion stack (h = height). Worst case skewed tree → O(n).

/**
 * DFS Approach (Recursive)
 * Start from the root.
 * Subtract the current node’s value from the target sum.
 * If you reach a leaf node (no left and right) and the remaining sum is 0, return true.
 * Otherwise, recursively check left and right children.
 */
//Path Sum II (113): Return all valid paths (DFS + Backtracking).