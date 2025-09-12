package grind75.Week1;
// 98. Validate Binary Search Tree

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys strictly less than the node's key.
 * The right subtree of a node contains only nodes with keys strictly greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
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
public class ValidateBST {
    public boolean isValidBST(TreeNodeX root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);// initially start with -inf & +inf
        // Long instead of int to avoid integer overflow
    }

    private boolean dfs(TreeNodeX node, long left, long right){
        if(node == null){
            return true;
        }
        //If you used &&, that would mean both conditions must be violated simultaneously to return false.
        //ensures no duplicates sneak in on either side.
        if( node.val <= left || node.val >= right){ //If you forget whether it’s || or &&, just think: “Is one violation enough to make the tree invalid?” → Yes → ||.
            return false;
        }

        return dfs(node.left, left, node.val)
                && dfs(node.right, node.val, right);
    }
}

//Complexity
//Time: O(n) (visit every node once)
//Space: O(h) (recursion stack, h = height of tree; worst case O(n) for skewed tree)

/**
 * Example Dry Run
 * Input Tree:
 *
 *       5
 *      / \
 *     3   7
 *        / \
 *       6   8
 *
 *
 * Start: dfs(root=5, min=-∞, max=+∞) → 5 is valid.
 * Left: dfs(3, min=-∞, max=5) → 3 is valid. Both children null → true.
 * Right: dfs(7, min=5, max=+∞) → 7 is valid.
 * Left: dfs(6, min=5, max=7) → 6 valid.
 * Right: dfs(8, min=7, max=+∞) → 8 valid.
 * All true → tree is a valid BST ✅.
 */