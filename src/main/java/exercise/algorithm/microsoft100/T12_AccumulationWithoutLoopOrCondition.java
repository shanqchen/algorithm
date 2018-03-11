package exercise.algorithm.microsoft100;
/*
第12题（语法）
题目：求1+2+…+n，
要求不能使用乘除法、for、while、if、else、switch、case等关键字以及条件判断语句（A?B:C）。
*/
public class T12_AccumulationWithoutLoopOrCondition {

    //看到题目的要求我们想到应该使用递归，但是递归的终止条件该怎么表示呢，通常都是用条件语句进行判断的
    public int accumulation(int n){
        
        if(1 == n){
            return n;
        }else{
            return n + accumulation(n - 1);
        }
    }
    
    //参考网上的方法：用逻辑与&&与短路特性实现递归终止
    //boolean ans = (n>0)&&
    //当n>0时，会一直递归执行Sum_Solution(n-1)
    //直到n==0，开始return sum
    //ref: http://blog.csdn.net/u014282557/article/details/72867512
    public int sumSolution(int n){
        int sum = n;
        boolean ans = (n > 0) && ((sum += sumSolution(n - 1)) > 0);
        return sum;
    }
    
    public static void main(String[] args) {
        int n = 100;
        T12_AccumulationWithoutLoopOrCondition t = new T12_AccumulationWithoutLoopOrCondition();
        System.out.println(t.sumSolution(n));
    }
}
