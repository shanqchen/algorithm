package exercise.algorithm.microsoft100;

import java.util.LinkedList;

/*
4.在二元树中找出和为某一值的所有路径（树）

题目：输入一个整数和一棵二元树。
从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。
打印出和与输入整数相等的所有路径。
例如 输入整数22和如下二元树
    10  
  /   /   
 5    12   
/ \     
4  7
则打印出两条路径：10, 12和10, 5, 7。
*/

//refer: https://www.cnblogs.com/qi09/archive/2011/05/24/2055643.html
public class T4_FindAllPaths {

    //用LinkedList实现栈Stack
    LinkedList<Integer> path = new LinkedList<>();
    int curSum = 0;
    int expectSum = 22;
    
    public void findPath(TreeNode node){
        
        if(null == node) return;
        
        curSum += node.val;
        path.addFirst(node.val);;
        
        if(null == node.left && null == node.right){
            //leaf
            if(curSum == expectSum){
                //print path
                for(int i = path.size() - 1; i >= 0; i--){
                    System.out.print(path.get(i) + " ");
                }
                System.out.println();
            }
        }
        
        if(null != node.left){
            findPath(node.left);
        }
        
        if(null != node.right){
            findPath(node.right);
        }
        
        curSum -= node.val;
        
        path.removeFirst();
    }
    
    public static void main(String[] args) {
        int[] preOrder = { 10, 5, 4, 7, 12 };
        int[] inOrder = { 4, 5, 7, 10, 12 };
        
        TreeNode tree = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        T4_FindAllPaths t = new T4_FindAllPaths();
        t.findPath(tree);
        
    }
}
