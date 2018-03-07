package exercise.algorithm.microsoft100;

public class SNode {

    int val;
    SNode next;
    
    public SNode(int x){
        this.val = x;
    }
    
    public static void print(SNode head){
        while(null != head){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
