package exercise.algorithm.leetcode.tree;

public class E_TrimABinarySearchTree_669 {
    
    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if(null == root){
            return null;
        }
        if(root.val < L){
            return trimBST(root.right, L, R);
        }
        if(root.val > R){
            return trimBST(root.left, L, R);
        }
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
    
    public static void main(String[] args) {
        int[] preOrder = {3, 0, 2, 1, 4};
        int[] inOrder = {0, 1, 2, 3, 4};
        TreeNode bst = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        
        int L = 1, R = 3;
        TreeNode trimBst = trimBST(bst, L, R);
        TreeUtils.preOrderTraverse(trimBst);
    }
}
