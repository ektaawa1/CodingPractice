package top150LC.Week6;

/**
 * Approach
 * Base case: If root is null, return null.
 * If root is equal to either p or q, return root.
 * Recursively check left and right subtree.
 * If both return non-null, current node is the LCA.
 * If only one is non-null, propagate it upward.
 */
public class LCAOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!= null && right != null){
            return root; // p in one subtree, q in the other → root is LCA
        }else if(left != null){
            return left; // both nodes are in the left subtree
        }
        else{
            return right; // both nodes are in the right subtree or null
        }
    }
}
//TC = O(n)
// SC = O(h) Recursion depth = tree height (h).
