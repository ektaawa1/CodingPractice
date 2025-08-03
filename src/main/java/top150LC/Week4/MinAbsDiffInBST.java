package org.Week4;

/**
 * Given the root of a Binary Search Tree (BST), return the
 * minimum absolute difference between the values of any two different nodes in the tree.
 */
class TreeNodeB {
      int val;
      TreeNodeB left;
      TreeNodeB right;
      TreeNodeB() {}
      TreeNodeB(int val) { this.val = val; }
      TreeNodeB(int val, TreeNodeB left, TreeNodeB right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class MinAbsDiffInBST {
    Integer prev = null;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNodeB root) {
        inorder(root);
        return minDiff;
    }
    private void inorder(TreeNodeB node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inorder(node.right);
    }
}
