package exercise.algorithm.microsoft100;

//用一种算法来颠倒一个链接表的顺序。现在在不用递归式的情况下做一遍。
//ref: http://blog.csdn.net/hahavslinb/article/details/45533015
public class T8_3_1_ReverseList {

    //方法一：非递归，三指针法
    //p -> q <- h  j -> k
    //假如现在反转q和h,那么在反转之后，将和j失去关联，所以在交换q和h之前，还需要记录j的信息
    //q, h, j分别用三个指针preNode, curNode, nextNode指向。
    public SNode reverseListWith3pointer(SNode head){
        
        if(null == head || null == head.next)
            return head;
        
        SNode preNode = null;
        SNode curNode = head;
        while(null != curNode){
            SNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        
        return preNode;
    }
    
    //方法二：非递归，利用栈保存所有节点，然后弹出
    //TODO
    
    //方法三：递归
    public SNode reverseListWithRecursion(SNode head){
        
        if(null == head || null == head.next){
            return head;
        }
        
        SNode nextNode = head.next;
        head.next = null;
        
        SNode reverseRest = reverseListWithRecursion(nextNode); //尾节点
        nextNode.next = head;
        return reverseRest;
    }
    
    
    public static void main(String[] args) {
        
        T8_3_1_ReverseList t = new T8_3_1_ReverseList();
        
        SNode p1 = new SNode(3);
        SNode p2 = new SNode(5);
        SNode p3 = new SNode(7);
        SNode p4 = new SNode(9);
        SNode p5 = new SNode(11);
        SNode p6 = new SNode(13);
        
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        
        SNode.print(p1);
//        SNode result = t.reverseListWith3pointer(p1);
//        SNode.print(result);
        
        SNode result2 = t.reverseListWithRecursion(p1);
        SNode.print(result2);
    }
}
