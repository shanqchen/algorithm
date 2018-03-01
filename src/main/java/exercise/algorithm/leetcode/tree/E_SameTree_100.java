package exercise.algorithm.leetcode.tree;

import java.util.Stack;

public class E_SameTree_100 {

    //recursive
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(null == p && null == q)
            return true;
        
        if(null == p || null == q || p.val != q.val)
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    //iteration: level traversal, preorder traversal, inorder traversal, postorder traversal
    //preorder example
    public static boolean isSameTreeIteration(TreeNode p, TreeNode q){
        
        Stack<TreeNode> pstack = new Stack<>();
        Stack<TreeNode> qstack = new Stack<>();
        
        if(null != p)
            pstack.push(p);
        if(null != q)
            qstack.push(q);
        
        while(!pstack.isEmpty() && !qstack.isEmpty()){
            TreeNode node1 = pstack.pop();
            TreeNode node2 = qstack.pop();
            
            if(node1.val != node2.val)
                return false;
            
            if(null != node1.left) pstack.push(node1.left);
            if(null != node2.left) qstack.push(node2.left);
            if(pstack.size() != qstack.size())
                return false;
            
            if(null != node1.right) pstack.push(node1.right);
            if(null != node2.right) qstack.push(node2.right);
            if(pstack.size() != qstack.size())
                return false;
        }
        
        return pstack.size() == qstack.size();
    }
    
    
    public static void main(String[] args) {
        int[] preOrderp = {1, 2, 3};
        int[] inOrderp = {2, 1, 3};
        
        int[] preOrderq = {1, 2, 3};
        int[] inOrderq = {2, 1, 3};
        
        TreeNode p = TreeUtils.ConstructBinaryTree(preOrderp, inOrderp);
        TreeNode q = TreeUtils.ConstructBinaryTree(preOrderq, inOrderq);
        
//        System.out.println(isSameTree(p, q));
        System.out.println(isSameTreeIteration(p, q));
        
        int[] preOrderp1 = {1, 2};
        int[] inOrderp1 = {2, 1};
        
        int[] preOrderq1 = {1, 2};
        int[] inOrderq1 = {1, 2};
        
        TreeNode p1 = TreeUtils.ConstructBinaryTree(preOrderp1, inOrderp1);
        TreeNode q1 = TreeUtils.ConstructBinaryTree(preOrderq1, inOrderq1);
        
//        System.out.println(isSameTree(p1, q1));
        System.out.println(isSameTreeIteration(p1, q1));
    }
}
