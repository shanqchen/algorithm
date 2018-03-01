package exercise.algorithm.microsoft100;

import java.util.Stack;

/*
2.设计包含min函数的栈（栈）
定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。
要求函数min、push以及pop的时间复杂度都是O(1)。
*/

//ref: http://blog.csdn.net/sgbfblog/article/details/7752878
public class T2_minStack {

    //方法一：辅助栈
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public void push(int elem){
        dataStack.push(elem);
        if(minStack.isEmpty() || minStack.peek() > elem){
            minStack.push(elem);
        }
    }
    
    public int pop(){
        if(dataStack.isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        int elem = dataStack.pop();
        
        if(elem == minStack.peek())
            minStack.pop();
        
        return elem;
    }
    
    public int min(){
        if(minStack.isEmpty()){
            throw new RuntimeException("最小值栈为空");
        }
        return minStack.peek();
    }
    
    public static void main(String[] args) {
        T2_minStack t = new T2_minStack();
        t.push(3);
        System.out.println(t.min());
        t.push(2);
        t.push(5);
        t.push(4);
        System.out.println(t.min());
        t.push(2);
        System.out.println(t.min());
        t.push(1);
        System.out.println(t.min());
        t.pop();
        System.out.println(t.min());
    }
}
