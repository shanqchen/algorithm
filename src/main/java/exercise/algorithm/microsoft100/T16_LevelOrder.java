package exercise.algorithm.microsoft100;
/*
第16题（树）：
题目（微软）：
输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。  
例如输入

   8
  / /
 6 10
/ / / /
5 7 9 11

输出8 6 10 5 7 9 11。
*/

import java.util.LinkedList;

public class T16_LevelOrder {

    public void levelOrder(TreeNode root){
        if(null == root){
            return;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() > 0){
            TreeNode node = queue.removeFirst();
            System.out.print(node.val + " ");
            if(null != node.left){
                queue.add(node.left);
            }
            
            if(null != node.right){
                queue.add(node.right);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] preOrder = {8, 6, 5, 7, 10, 9, 11};
        int[] inOrder = {5, 6, 7, 8, 9, 10, 11};
        TreeNode bst = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        TreeUtils.inOrderTraverse(bst);
        System.out.println();
        
        T16_LevelOrder t = new T16_LevelOrder();
        t.levelOrder(bst);
    }/*output
    5 6 7 8 9 10 11 
    8 6 10 5 7 9 11
    */ 
}
