package exercise.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class E_SumOfLeftLeaves_404 {
    
    //recursive
    public static int sumOfLeftLeaves(TreeNode root) {
        
        if(null == root)
            return 0;
        
        if(null != root.left && null == root.left.left && null == root.left.right)
            return root.left.val + sumOfLeftLeaves(root.right);
        
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    
    //iteration
    public static int sumOfLeftLeaves2(TreeNode root){
        if(null == root || null == root.left && null == root.right)
            return 0;
        
        int sum = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            
            if(null != node.left && null == node.left.left && null == node.left.right)
                sum += node.left.val;
            if(null != node.left)
                q.offer(node.left);
            if(null != node.right)
                q.offer(node.right);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        
        TreeNode bt = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        
        int sum1 = sumOfLeftLeaves(bt);
        int sum2 = sumOfLeftLeaves2(bt);
        
        System.out.println(sum1);
        System.out.println(sum2);
    }
}
