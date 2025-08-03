package org.Week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelBT {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return averages;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            long sum = 0;
            double avg = 0.0;
            int qSize = queue.size();

           for(int i=0; i<qSize; i++){
               TreeNode currNode = queue.poll();
               sum += currNode.val;
               if(currNode.left!= null) queue.offer(currNode.left);
               if(currNode.right != null) queue.offer(currNode.right);
           }
            avg = (double) sum/qSize;
           averages.add(avg);
        }
        return averages;
    }
}
