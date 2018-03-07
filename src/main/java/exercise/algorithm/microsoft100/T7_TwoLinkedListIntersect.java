package exercise.algorithm.microsoft100;

import java.util.HashSet;
import java.util.Set;

/*
第7题（链表）
微软亚院之编程判断俩个链表是否相交
给出俩个单向链表的头指针，比如h1，h2，判断这俩个链表是否相交。
为了简化问题，我们假设俩个链表均不带环。

问题扩展：
1.如果链表可能有环呢?
2.如果需要求出俩个链表相交的第一个节点呢?
*/

//ref: http://blog.csdn.net/jiary5201314/article/details/50990349

public class T7_TwoLinkedListIntersect {

    //1. 无环情况：判断最后一个节点是否相同
    public boolean isLastNodeSame(SNode h1, SNode h2){
        
        if(null == h1 || null == h2)
            return false;
        
        while(null != h1.next){
            h1 = h1.next;
        }
        
        while(null != h2.next){
            h2 = h2.next;
        }
        
        if(h1 == h2)
            return true;
        
        return false;
    }
    
    //2. 无环情况： 哈希计数法
    public boolean hashCount(SNode h1, SNode h2){
        
        if(null == h1 || null == h2) return false;
        
        Set<String> addrSet = new HashSet<>();
        
        while(h1 != null){
            addrSet.add(Integer.toHexString(h1.hashCode()));
            h1 = h1.next;
        }
        
        while(h2 != null){
            if(addrSet.contains(Integer.toHexString(h2.hashCode()))){
                return true;
            }
            h2 = h2.next;
        }
        
        return false;
    }
    
    //3. 有环情况： 快慢双指针法
    //ref: http://blog.csdn.net/ldong2007/article/details/4544203
    
    
    public static void main(String[] args) {
        
        T7_TwoLinkedListIntersect t = new T7_TwoLinkedListIntersect();
        
        //1.
        SNode p1 = new SNode(3);
        SNode p2 = new SNode(5);
        SNode p3 = new SNode(7);
        SNode p4 = new SNode(9);
        SNode p5 = new SNode(11);
        SNode p6 = new SNode(13);
        
        SNode q1 = new SNode(2);
        SNode q2 = new SNode(4);
        
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        
        q1.next = q2;
        q2.next = p4;
        
        boolean result1 = t.isLastNodeSame(p1, q1);
        System.out.println(result1);
        
        //2.
        boolean result2 = t.hashCount(p1, q1);
        System.out.println(result2);
    }
}
