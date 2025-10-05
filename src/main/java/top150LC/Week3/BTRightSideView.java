package top150LC.Week3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//199. Binary Tree Right Side View
// BFS approach https://algo.monster/liteproblems/199
public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return rightList;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int qSize = queue.size();
            int rightVal=0;
            for(int i = 0; i<qSize; i++){
                TreeNode currNode = queue.poll();
                rightVal = currNode.val; //overwriting the value of node to right node value always
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
            rightList.add(rightVal);
        }
        return rightList;
    }
}
