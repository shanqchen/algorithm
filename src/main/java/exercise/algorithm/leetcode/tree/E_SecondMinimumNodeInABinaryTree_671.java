package exercise.algorithm.leetcode.tree;

public class E_SecondMinimumNodeInABinaryTree_671 {

    //根据题目描述，我们推出根节点值必为最小值
    public int findSecondMinimumValue(TreeNode root) {
        if(null == root) return -1;
        int first = root.val;
        int second = Integer.MAX_VALUE;
        
        second = findSecondMinimumValue(root, first, second);
        
        return second == Integer.MAX_VALUE ? -1 : second;
        
    }
    
    public int findSecondMinimumValue(TreeNode node, int first, int second){
        if(null == node) return second;
        
        if(first != node.val && node.val < second){
            second = node.val;
        }
        
        second = findSecondMinimumValue(node.left, first, second);
        second = findSecondMinimumValue(node.right, first, second);
        
        return second;
    }
    
    public static void main(String[] args) {
        int[] preOrder = {2, 2, 5, 5, 7};
        int[] inOrder = {2, 2, 5, 5, 7};
        
//        TreeNode bt = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
//        E_SecondMinimumNodeInABinaryTree_671 s = new E_SecondMinimumNodeInABinaryTree_671();
//        int result = s.findSecondMinimumValue(bt);
//        System.out.println(result);
        
    }
}
