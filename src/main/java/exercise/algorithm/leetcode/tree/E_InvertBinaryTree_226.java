package exercise.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class E_InvertBinaryTree_226 {

    //recursive
    public static TreeNode invertTree(TreeNode root) {
        if(null == root)
            return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
    
    //迭代
    public static TreeNode invertTree2(TreeNode root){
        
        if(null == root) return null;
        
        //层序遍历二叉树，然后交换每一层的左右子树
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            
            //switch
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            
            if(null != node.left)
                q.offer(node.left);
            if(null != node.right)
                q.offer(node.right);
            
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        int[] preOrder = {4, 2, 1, 3, 7, 6, 9};
        int[] inOrder = {1, 2, 3, 4, 6, 7, 9};
        
        TreeNode bt = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        TreeNode sbt = invertTree2(bt);
        
        TreeUtils.inOrderTraverse(sbt);
    }
}
