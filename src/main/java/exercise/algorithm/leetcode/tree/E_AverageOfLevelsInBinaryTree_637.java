package exercise.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E_AverageOfLevelsInBinaryTree_637 {

    public static List<Double> averageOfLevels(TreeNode root) {
        if(null == root)
            return null;
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(queue.size() > 0){
            //按层序遍历二叉树，每一层的节点加入队列
            int s = queue.size();
            double sum = 0.0;
            
            for(int i = 0; i < s; i++){
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if(null != tmp.left){
                    queue.offer(tmp.left);
                }
                if(null != tmp.right){
                    queue.offer(tmp.right);
                }
            }
            result.add(sum/s);
            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode bt = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        
        List<Double> aveList = averageOfLevels(bt);
        
        for(Double ave : aveList){
            System.out.print(ave + ", ");
        }
        
    }
}
