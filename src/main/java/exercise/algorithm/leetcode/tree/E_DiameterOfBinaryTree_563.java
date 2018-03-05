package exercise.algorithm.leetcode.tree;

public class E_DiameterOfBinaryTree_563 {

    //http://blog.csdn.net/zhyh1435589631/article/details/65939602
    //method 1
    //求树的直径，有三种情况，最长路径在左子树上；最长路径在右子树上；最长路径跨root节点，为左右子树深度之和
    public int diameterOfBinaryTree(TreeNode root) {
        if(null == root){
            return 0;
        }
        
        int leftDiameter = 0, rightDiameter = 0, leftDepth = 0, rightDepth = 0;
        
        if(null != root.left){
            leftDepth = getDepth(root.left);
            leftDiameter = diameterOfBinaryTree(root.left);
        }
        
        if(null != root.right){
            rightDepth = getDepth(root.right);
            rightDiameter = diameterOfBinaryTree(root.right);
        }
        
        return Math.max(Math.max(leftDiameter, rightDiameter), leftDepth + rightDepth);
    }
    
    //获取树的深度
    public int getDepth(TreeNode root){
        if(null == root){
            return 0;
        }
        
        int leftDepth = 0, rightDepth = 0;
        
        if(null != root.left){
            leftDepth = getDepth(root.left);
        }
        
        if(null != root.right){
            rightDepth = getDepth(root.right);
        }
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    //method 2
    //求出每个节点为根的树的直径
    //实际上对于每一个节点我们都可以计算以他为根节点的diameter的长度，
    //那么我们只需要在这个过程中，挑选得到长度最长的那个diameter就可以了
    //抽象：根节点和左子树（无子树）、右子树（无子树），统计出该三节点树的直径，然后将该三节点子树作为一个节点
    int max = 0;
    
    public int diameterOfBinaryTree2(TreeNode root){
        maxDepth2(root);
        return max;
    }
    
    public int maxDepth2(TreeNode root){
        if(null == root)
            return 0;
        
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        
        max = Math.max(max, leftDepth + rightDepth);
        
        //返回当前树的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    //Test
    public static void main(String[] args) {
        int[] preOrder = {1};
        int[] inOrder = {1};
        
        TreeNode bt = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        
        E_DiameterOfBinaryTree_563 diameter = new E_DiameterOfBinaryTree_563();
        int result = diameter.diameterOfBinaryTree(bt);
        System.out.println(result);
    }
}
