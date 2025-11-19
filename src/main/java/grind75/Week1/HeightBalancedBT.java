package grind75.Week1;
// 110. Balanced Binary Tree
/**
 * Balanced Binary Tree-
 * A height balanced binary tree is defined as a binary tree in which
 * the height of the left and the right subtree of any node differ by
 * not more than 1.
 */
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
  //Using DFS approach-
// DFS = explore as deep as possible before coming back up (preorder, inorder, postorder).
// We’re recursively going down to the leaves before checking balance on the way back up
// → that’s postorder DFS traversal.
public class HeightBalancedBT {
      public boolean isBalanced(TreeNode root) {

          return dfs(root) != -1;
      }
        //The below helper method returns:
      // the height of the subtree if it’s balanced
      // -1 if it’s not balanced
      private int dfs(TreeNode node){
          //base case
          if(node == null){
              return 0;
          }

          int leftHeight = dfs(node.left);
          if(leftHeight == -1){
              return -1;
          }

          int rightHeight = dfs(node.right);
          if(rightHeight == -1){
              return -1;
          }
          if(Math.abs(leftHeight - rightHeight) > 1){
              return -1;
          }

          return Math.max(leftHeight, rightHeight) + 1;
      }
    // For any node, the height of its subtree =
      //1 (for the node itself) + the greater height of its two children.
}

/**
 * Why DFS works best here?
 * We need heights of left & right subtrees before checking balance.
 * DFS naturally gives us that in one pass (bottom-up).
 * BFS would need extra bookkeeping of heights at each level and multiple passes → less efficient.
 *
 * So the flow is:
 * DFS down (left & right).
 * While coming back up, compute height and check balance.
 * If any subtree is unbalanced, return -1 immediately (early stop).
 * This is why the algorithm runs in O(n) instead of O(n²).
 */

// TC = O(n), each node is visited once
// SC = O(h), where h = tree height (recursion stack). Worst-case skewed tree = O(n).

/**
 * Notes-Why Math.max(leftHeight, rightHeight) + 1?
 * leftHeight = height of left subtree, rightHeight = height of right subtree
 * Math.max(leftHeight, rightHeight) = the taller side + 1 = count the current node
 *
 * Example-
 *     1
 *    / \
 *   2   3
 *  /
 * 4
 *
 * Node 4: left=0, right=0 → height = max(0,0)+1 = 1
 * Node 2: left=1 (from node 4), right=0 → height = max(1,0)+1 = 2
 * Node 3: left=0, right=0 → height = 1
 * Node 1: left=2, right=1 → height = max(2,1)+1 = 3
 * So the whole tree’s height = 3.
 */

/**
 * An empty tree is considered balanced because:
 * There are no nodes where height difference could exist.
 * The height of an empty tree is conventionally 0.
 */