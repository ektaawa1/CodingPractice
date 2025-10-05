package top150LC.Week8;

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

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftCount = countNodes(root.left); //count nodes in the left subtree
        int rightCount = countNodes(root.right); //count nodes in the right subtree

        return leftCount + rightCount + 1; //add 1 for the current root node
    }
//Complexity Time: O(log² n)
// Each height calculation is O(log n)
//At most O(log n) recursive calls
//Total = O(log n × log n)
//Space: O(log n) for recursion stack
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;

        int hl = leftHeight(root);
        int hr = rightHeight(root);

        if (hl == hr) {
            return (1 << hl) - 1; // 2^hl - 1
        } else {
            return 1 + countNodes1(root.left) + countNodes1(root.right);
        }
    }
    private int leftHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }

    private int rightHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.right;
        }
        return h;
    }
}

//Time: O(n) → visits every node once
//Space: O(h) → recursion stack (h = height of tree, O(log n) for balanced tree)

/**
 * A complete binary tree has two properties:
 * All levels are completely filled except possibly the last.
 * The last level is filled from left to right.
 * From this, if the left-most path height equals the right-most path height, the tree is actually a perfect binary tree.
 * Number of nodes in a perfect binary tree of height h = 2^h - 1
 */
