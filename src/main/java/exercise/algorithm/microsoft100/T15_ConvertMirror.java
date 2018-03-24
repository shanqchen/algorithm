package exercise.algorithm.microsoft100;

import java.util.LinkedList;

/*
第15题（树）：
题目：输入一颗二元查找树，将该树转换为它的镜像，
即在转换后的二元查找树中，左子树的结点都大于右子树的结点。
用递归和循环两种方法完成树的镜像转换。  
例如输入：
  8
  / /
  6 10
 // //
5 7 9 11

输出：
   8
  / /
 10 6
 // //
11 9 7 5

定义二元查找树的结点为：
struct BSTreeNode // a node in the binary search tree (BST)
{
  int m_nValue; // value of node
  BSTreeNode *m_pLeft; // left child of node
  BSTreeNode *m_pRight; // right child of node
};
*/

//ref: https://www.cnblogs.com/wuzetiandaren/p/4260432.html
public class T15_ConvertMirror {

    //递归法
    public void convertMirrorInRecursion(TreeNode root){
        if(null != root){
            swap(root);
            convertMirrorInRecursion(root.left);
            convertMirrorInRecursion(root.right);
        }
    }
    
    public void swap(TreeNode node){
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
    
    //层序遍历
    public void covertMirrorInLeverOrder(TreeNode root){
        
        if(null == root){
            return;
        }
        //queue
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(queue.size() != 0){
            TreeNode node = queue.removeFirst();
            swap(node);
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
        
        T15_ConvertMirror t = new T15_ConvertMirror();
//        t.convertMirrorInRecursion(bst);
        t.covertMirrorInLeverOrder(bst);
        TreeUtils.inOrderTraverse(bst);
        
    }
}
