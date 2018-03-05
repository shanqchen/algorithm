package exercise.algorithm.leetcode.tree;

/*
注意：
The tilt of a tree node is defined as the absolute difference between 
the sum of all left subtree node values 
and the sum of all right subtree node values. 
Null node has tilt 0.
节点斜度是左子树所有节点值之和与右子树所有节点值之和的差的绝对值
*/
public class E_BinaryTreeTilt_563 {

    int res = 0;
    
    public int findTilt(TreeNode root) {
        postOrder(root);
        return res;
    }
    
    public int postOrder(TreeNode node){
        if(null == node)
            return 0;
        
        int leftSum = postOrder(node.left);
        int rightSum = postOrder(node.right);
        
        res += leftSum > rightSum ? leftSum - rightSum : rightSum - leftSum;
        
        return leftSum + rightSum + node.val;
    }
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 3};
        int[] inOrder = {2, 1, 3};
        
        TreeNode bt = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        
        E_BinaryTreeTilt_563 btTilt = new E_BinaryTreeTilt_563();
        int tilt = btTilt.findTilt(bt);
        System.out.println(tilt);
    }
}
