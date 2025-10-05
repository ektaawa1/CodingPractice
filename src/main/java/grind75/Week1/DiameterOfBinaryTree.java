package grind75.Week1;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class DiameterOfBinaryTree {
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    private int dfs(TreeNode node){
        if (node == null) return 0;

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1; // height = 1 + max(lf,rh)
    }
}

// Complexity
//Time: O(n) → visit every node once
//Space: O(h) → recursion stack,
// where h = height of tree (O(log n) for balanced, O(n) for skewed)

/**
 *       1
 *      / \
 *     2   3
 *    / \
 *   4   5
 *
 *   Step-by-step recursion:
 *
 * Start at root 1 → call dfs(1).
 * First compute dfs(2).
 * dfs(2):
 * Compute dfs(4):
 * dfs(4.left) = 0, dfs(4.right) = 0
 * leftHeight=0, rightHeight=0 → diameter = 0
 * return height = 1
 * Compute dfs(5):
 * Similar to 4 → return 1
 * Now at node 2:
 * leftHeight=1, rightHeight=1
 * diameter = 1+1=2 → update maxDiameter=2
 * return height = max(1,1)+1 = 2
 * Back at dfs(3):
 * left and right null → heights 0,0
 * diameter = 0+0=0 → no update
 * return height = 1
 * Finally at dfs(1):
 * leftHeight=2, rightHeight=1
 * diameter = 2+1=3 → update maxDiameter=3
 * return height = max(2,1)+1 = 3
 * Results:
 * maxDiameter = 3
 * That corresponds to path [4 → 2 → 1 → 3]
 */
