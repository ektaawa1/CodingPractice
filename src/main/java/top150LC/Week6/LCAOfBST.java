package top150LC.Week6;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is
 * defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */

/**
 * In a BST:
 * Left child values < parent value
 * Right child values > parent value
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class LCAOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null){
            if(p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            } else if (p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return curr;
    }
}

/**
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 * according to the LCA definition.
 */

// TC is  O(h) where h is the height of the tree.
// SC is O(1)


