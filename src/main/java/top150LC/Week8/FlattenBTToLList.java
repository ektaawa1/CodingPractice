package top150LC.Week8;
//114. Flatten Binary Tree to Linked List

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to
 * the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
class TreeNodeX {
    int val;
    TreeNodeX left;
    TreeNodeX right;
    TreeNodeX() {}
    TreeNodeX(int val) { this.val = val; }
    TreeNodeX(int val, TreeNodeX left, TreeNodeX right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

/**
 * Idea: Flatten left, then right
 * Recursively flatten the left subtree. Recursively flatten the right subtree.
 * If there’s a left subtree:
 * Find the rightmost node of the left subtree.
 * Attach the original right subtree to the right of that rightmost node.
 * Move the flattened left subtree to the right: root.right = root.left
 * Set root.left = null
 * This preserves preorder: root → left → right.
 */
public class FlattenBTToLList {
    public void flatten(TreeNodeX root) {
        dfs(root);
    }
    // Flattens subtree rooted at 'node' and returns its tail
    private TreeNodeX dfs(TreeNodeX node){
        if(node == null) return null;

        TreeNodeX leftTail = dfs(node.left);
        TreeNodeX rightTail = dfs(node.right);
        //edge case: If one of them is empty(left or right tail)
        if(leftTail != null){//or node.left != null
            leftTail.right = node.right;// Connect leftTail's right to node's right
            node.right = node.left; // joining the root next to left node //// Move left subtree to the right
            node.left = null; // making left side of tree as null
        }// if leftTail is null then do nothing
        //if leftTail is empty & rightTail is not empty this means we have flattened the right side

        // Return the "last node" (tail) of the flattened subtree
        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return node;
    }
}
/**
 *     1
 *    / \
 *   2   5
 *  / \    \
 * 3   4    6
 *
 * Flatten 2 → 3,4 → 2 → 3 → 4
 * Flatten 5 → 6 → 5 → 6
 *
 * At root 1:
 * LeftTail = 4
 * RightTail = 6
 *
 * Connect 4.right = 5, then 1.right = 2, 1.left = null
 * Final: 1 → 2 → 3 → 4 → 5 → 6
 */
