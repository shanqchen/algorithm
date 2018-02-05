package exercise.algorithm.leetcode.tree;

/*
 * 617. Merge Two Binary Trees
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 */
public class MergeTwoBinaryTrees_617 {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(null == t1)
            return t2;
        if(null == t2)
            return t1;
        TreeNode t = new TreeNode(t1.val + t2.val);
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);
        return t;
    }
    
    public static void main(String[] args) {
        
        int[] preOrderT1 = {1, 3, 5, 2};
        int[] inOrderT1 = {5, 3, 1, 2};
        TreeNode t1 = TreeUtils.ConstructBinaryTree(preOrderT1, inOrderT1);
        
        int[] preOrderT2 = {2, 1, 4, 3, 7};
        int[] inOrderT2 = {1, 4, 2, 3, 7};
        TreeNode t2 = TreeUtils.ConstructBinaryTree(preOrderT2, inOrderT2);
        
        TreeNode t = mergeTrees(t1, t2);
        TreeUtils.preOrderTraverse(t);
    }
}
