package top75LC.Week3;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
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
public class SearchInBST {
    //Recursive
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        if(val < root.val){ // If val is smaller, go left
            return searchBST(root.left, val);
        } else{
            return searchBST(root.right, val); // Else go right
        }
    }
    //Iterative-better for large Trees
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root; // either null (not found) or the node
    }
}
