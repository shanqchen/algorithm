package exercise.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E_BinaryTreeLevelOrderTraversalII_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
//        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(null == root)
            return result;
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<TreeNode> nodeList = new ArrayList<>();
            List<Integer> valueList = new ArrayList<>();
            
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                nodeList.add(node);
                valueList.add(node.val);
            }
            
            temp.add(valueList);
            
            for(TreeNode node : nodeList){
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }
            }
            
        }
        
        for(int i = temp.size() - 1; i >= 0; i--){
            result.add(temp.get(i));
        }
        
        return result;
    }
}
