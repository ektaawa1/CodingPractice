package top150LC.Week8;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 *
 * Example:
 * Input: p = [1,2], q = [1,null,2], Output: false
 * Input: p = [1,2,3], q = [1,2,3], Output: true
 * Input: p = [1,2,1], q = [1,1,2], Output: false
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q){
            return true;
        }

        if( p == null || q == null || p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

//TC: O(n)
//
//Visits each node exactly once
//
//n = number of nodes in both trees
//SC: O(h)
//
//Recursion stack height = h
//
//h = O(log n) for balanced tree, h = O(n) for skewed tree