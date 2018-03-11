package exercise.algorithm.microsoft100;
/*
第13题（链表）：
题目：输入一个单向链表，输出该链表中倒数第k个结点。链表的倒数第0个结点为链表的尾指针。
链表结点定义如下：  
struct ListNode
{
  int m_nKey;
  ListNode* m_pNext;
};
*/
public class T13_ReciprocalNodeK {

    //double pointer
    //两个指针，一个先走K步，然后两个指针一起走，当前面的指针走到尾节点时，返回后面的指针
    public SNode reciprocalNodeK(SNode head, int k){
        if(null == head || k < 0){
            return null;
        }
        
        SNode front = head, back = head;
        
        int i = 0;
        while(i < k && null != front){
            front = front.next;
            i++;
        }
        
        if(null == front){
            return null;
        }
        
        while(null != front.next){
            //让front走到尾节点
            front = front.next;
            back = back.next;
        }
        
        return back;
    }
    
    public static void main(String[] args) {
        SNode head = new SNode(1);
        SNode n2 = new SNode(3);
        SNode n3 = new SNode(5);
        SNode n4 = new SNode(7);
        SNode n5 = new SNode(9);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        T13_ReciprocalNodeK t = new T13_ReciprocalNodeK();
        SNode result = t.reciprocalNodeK(head, 0);      //临界点
//        SNode result = t.reciprocalNodeK(head, 4);    //临界点
//        SNode result = t.reciprocalNodeK(head, 5);    //临界点
        if(null == result){
            System.out.println(Integer.MIN_VALUE);
        }else{
            System.out.println(result.val);
        }
    }
}
