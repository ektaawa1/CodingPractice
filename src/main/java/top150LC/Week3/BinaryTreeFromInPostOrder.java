package org.Week3;

import java.util.HashMap;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTreeFromInPostOrder {
    HashMap<Integer,Integer> indexMap = new HashMap<>();
    int postOrderIndex;
    public TreeNode1 buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length-1;

        for(int i = 0; i<inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
        return buildRecursiveTree(postorder, 0, inorder.length-1);
    }

    private TreeNode1 buildRecursiveTree(int[] postorder, int leftIndex, int rightIndex) {
        if(leftIndex > rightIndex){
            return null;
        }

        int rootVal = postorder[postOrderIndex--];
        TreeNode1 root = new TreeNode1(rootVal);

        int inorderIndex = indexMap.get(rootVal);

        //postorder is [Left, Right, Root]
        //We have built root so after root is Right Node so we will build it first.
        root.right = buildRecursiveTree(postorder, inorderIndex+1, rightIndex);
        root.left = buildRecursiveTree(postorder, leftIndex, inorderIndex-1);

        return root;
    }
}
