package exercise.algorithm.microsoft100;
/*
第24题（链表）：
链表操作，单链表就地逆置
*/
public class T_24_ReverseSList {

    public SNode reverseSList(SNode head){
        if(null == head || null == head.next){
            return head;
        }
        
        SNode pre = null;
        SNode cur = head;
        SNode nxt = null;
        while(null != cur){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        
        return pre;
    }
    
    public static void main(String[] args) {
        SNode s1 = new SNode(5);
        SNode s2 = new SNode(4);
        SNode s3 = new SNode(3);
        SNode s4 = new SNode(2);
        SNode s5 = new SNode(1);
        
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        
        SNode head = s1;
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        
        System.out.println();
        
        T_24_ReverseSList t = new T_24_ReverseSList();
        SNode result = t.reverseSList(s1);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
