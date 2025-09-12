package grind75.Week1;

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
