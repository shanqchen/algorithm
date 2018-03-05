package exercise.algorithm.microsoft100;

public class TreeUtils {

    public void print(TreeNode root){
        
    }
    
    public static TreeNode ConstructBinaryTree(int[] preOrder, int[] inOrder){
        if(null == preOrder || null == inOrder){
            return null;
        }
        
        return ConstructCore(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }
    
    /**
     * 利用前序遍历和中序遍历构造二叉树
     * @param preOrder
     * @param inOrder
     * @param startPreOrder
     * @param endPreOrder
     * @param startInOrder
     * @param endInorder
     * @return
     */
    public static TreeNode ConstructCore(int[] preOrder, int[] inOrder, int startPreOrder, int endPreOrder, int startInOrder, int endInOrder){
        
        if(startPreOrder > endPreOrder || startInOrder > endInOrder){
            return null;
        }
        
        TreeNode root = new TreeNode(preOrder[startPreOrder]);
        int divider = 0;
        while(divider <= endInOrder && inOrder[divider] != root.val){
            divider++;
        }
        
        int offSet = divider - startInOrder - 1;
        root.left = ConstructCore(preOrder, inOrder, startPreOrder + 1, startPreOrder + 1 + offSet, startInOrder, startInOrder + offSet);
        root.right = ConstructCore(preOrder, inOrder, startPreOrder + 2 + offSet, endPreOrder, divider + 1, endInOrder);
        
        return root;
    }
    
    /*
     * 中序遍历
     */
    public static void inOrderTraverse(TreeNode root){
        if(null != root){
            inOrderTraverse(root.left);
            System.out.print(root.val + " ");
            inOrderTraverse(root.right);
        }
    }
    
    /**
     * 前序遍历
     * @param root
     */
    public static void preOrderTraverse(TreeNode root){
        if(null != root){
            System.out.print(root.val + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }
    
    public static void main(String[] args) {
        int[] preOrder = { 6, 10, 4, 3, 1, 0, 7, 12 };
        int[] inOrder = { 4, 10, 3, 1, 6, 12, 7, 0 };
        
        TreeNode result = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        TreeUtils.inOrderTraverse(result);
        System.out.println();
        TreeUtils.preOrderTraverse(result);
    }
}

