package exercise.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class E_MaximumDepthOfBinaryTree_104 {

    //recursive
    public static int maxDepth1(TreeNode root) {
        if(null == root)
            return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }
    
    //层序遍历
    public static int maxDepth(TreeNode root) {
        if(null == root)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = q.poll();
                if(null != tmp.left)
                    q.offer(tmp.left);
                if(null != tmp.right)
                    q.offer(tmp.right);
            }
        }
        return level;
    }
    
    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode bt = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        
        int level = maxDepth(bt);
        System.out.println(level);
    }
}
