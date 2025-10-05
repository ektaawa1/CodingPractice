package top150LC.Week3;

import java.util.HashMap;

// using Depth First Search algo
// Recursion
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
public class BinaryTreeFromPreInOrder {
    HashMap<Integer,Integer> indexMap = new HashMap<>();
    int preorderIndex = 0; // iterate the preorder arr

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //insert values in hashmap
        for(int i = 0; i< inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
        // call recursive function
        // we are sending preorder array to get the root node each time.
        // we are also sending the entire inorder array length initially
        // as we will have to track the starting and ending point each time
        // so that we will know which part to process
        return dfs(preorder, 0, inorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int leftIndex, int rightIndex) {
        //defining the base condition to exit recursive call
        // No elements left to build the tree
        if(leftIndex>rightIndex){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderIndex++]); //fetching the root node

        //Now finding the index of this root in inorder array hashmap
        int inorderIndex = indexMap.get(root.val);

        //now again build the remaining tree nodes using recursion
        root.left = dfs(preorder, leftIndex, inorderIndex-1);
        root.right = dfs(preorder, inorderIndex+1, rightIndex);
        return root; // return this fully built subtree rooted at 'root'
    }
}

// TC = O(n)
// SC = O(n) for hashmap + recursion stack

/**
 * Reason for return root:
 * At each recursion level:
 * You create a node (root) based on preorder.
 * You build its left subtree recursively (root.left = dfs(...)).
 * You build its right subtree recursively (root.right = dfs(...)).
 * You return the root — with its left and right children fully attached.
 * That way, the parent caller will receive the completed subtree for its left or right child.
 */
