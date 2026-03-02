package patternBased.trees;

import java.util.HashMap;

class TreeNode12 {
    int val;
    TreeNode12 left;
    TreeNode12 right;
    TreeNode12() {}
    TreeNode12(int val) { this.val = val; }
    TreeNode12(int val, TreeNode12 left, TreeNode12 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//Inorder- Left, Root, Right
//PostOrder- Left, Right, root
public class BinaryTreeFromInPostOrder {
    HashMap<Integer,Integer> indexMap = new HashMap<>();
    int postOrderIndex;
    public TreeNode12 buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length-1;

        for(int i = 0; i<inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
        return buildRecursiveTree(postorder, 0, inorder.length-1);
    }

    private TreeNode12 buildRecursiveTree(int[] postorder, int leftIndex, int rightIndex) {
        if(leftIndex > rightIndex){
            return null;
        }

        int rootVal = postorder[postOrderIndex--];
        TreeNode12 root = new TreeNode12(rootVal);

        int inorderIndex = indexMap.get(rootVal);

        //postorder is [Left, Right, Root]
        //We have built root so after root is Right Node so we will build it first.
        root.right = buildRecursiveTree(postorder, inorderIndex+1, rightIndex);
        root.left = buildRecursiveTree(postorder, leftIndex, inorderIndex-1);

        return root;
    }
}
