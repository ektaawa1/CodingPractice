package patternBased.trees;

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
//Dry Run Example-
/**
 * At node 6:
 * root == q → return 6
 * At node 5:
 * root == p → return 5
 * Notice something important:
 * Even though left returned 6,
 * we do NOT care.
 * Because we check:
 * if (root == p || root == q)
 *     return root;
 * Now go back to node 3:
 * left returns 5
 * right returns null
 * root != p and != q
 * So, if (left != null && right != null) → false
 * if (left != null) → true → return left (5)
 * So 3 returns 5.
 */
