package exercise.algorithm.microsoft100;
/*
 * 第18题（数组）：
题目：n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，
每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。
当一个数字删除后，从被删除数字的下一个继续删除第m个数字。
求出在这个圆圈中剩下的最后一个数字。
July：我想，这个题目，不少人已经 见识过了。
 */

//ref: https://blog.csdn.net/lzj509649444/article/details/7056742
//ref2: https://www.cnblogs.com/nice-forever/p/6607971.html

/*
 *                0                n=1
        f(n,m)={
                [f(n-1,m)+m]%n     n>1
 */
public class T18_DeleteTheMInCircle {

    public int lastRemaining(int n, int m){
        if(n < 1 || m < 1){
            return -1;
        }
        
        int last = 0;
        
        for(int i = 2; i <= n; i++){
            last = (last + m) % i;
        }
        
        return last;
    }
    
    public static void main(String[] args) {
        T18_DeleteTheMInCircle t = new T18_DeleteTheMInCircle();
        int target = t.lastRemaining(3, 1);
        System.out.println("target = " + target );
    }
}
