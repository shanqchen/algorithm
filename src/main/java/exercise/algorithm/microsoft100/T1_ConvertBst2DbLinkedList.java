package exercise.algorithm.microsoft100;


/*
1.把二元查找树转变成排序的双向链表（树）
题目：
输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。
要求不能创建任何新的结点，只调整指针的指向。
  10
 / /
 6  14
/ / / /
4  8 12 16
转换成双向链表
4=6=8=10=12=14=16。
*/
public class T1_ConvertBst2DbLinkedList {

    private TreeNode head, tail;
    
    //中序遍历
    public void traversal(TreeNode node){
        if(null == node)
            return;
        if(null != node.left)
            traversal(node.left);
        changeNode(node);
        if(null != node.right)
            traversal(node.right);
    }
    
    public void changeNode(TreeNode node){
        //初始时，双向链表中无节点，head及tail都为null
        if(null == head){
            head = node;
            tail = node;
        }else{
            //将新node的左指针指向当前tail, 再将当前tail的右指针指向新node,最后将tail后移
            node.left = tail;
            tail.right = node;
            tail = node;
        }
    }
    
    public void printHead(){
        while(null != head){
            System.out.print(head.val + " ");
            head = head.right;
        }
    }
    
    public void printTail(){
        while(null != tail){
            System.out.print(tail.val + " ");
            tail = tail.left;
        }
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(8, null, null);
        TreeNode node3 = new TreeNode(12, null, null);
        TreeNode node4 = new TreeNode(16, null, null);
        TreeNode node5 = new TreeNode(6, node1, node2);
        TreeNode node6 = new TreeNode(14, node3, node4);
        TreeNode node7 = new TreeNode(10, node5, node6);
        T1_ConvertBst2DbLinkedList t = new T1_ConvertBst2DbLinkedList();
        t.traversal(node7);
        System.out.println("双向链表从头节点向后遍历: ");
        t.printHead();
        System.out.println();
        System.out.println("双向链表从尾节点向前遍历: ");
        t.printTail();
    }
}
