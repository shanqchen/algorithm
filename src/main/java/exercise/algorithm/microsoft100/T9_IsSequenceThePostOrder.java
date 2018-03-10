package exercise.algorithm.microsoft100;

/*
思路：分析后序遍历的特点，序列的最后一个数应该是根结点，剩余的节点分为两个连续的子序列，
前一子序列的值小于最后一个数，后一子序列的值大于最后一个数。然后递归求解这两个子序列。

如果是判断是前序遍历也很简单，只不过根节点变为了第一个数，剩余的节点也是分为两个连续的子序列。
如果判断是中序遍历，更方便，只需扫描一遍，检查序列是不是排好序的，如果没有排好序，就不是中序遍历的结果。
*/

//ref:http://blog.csdn.net/wuzhekai1985/article/details/6619906
//    http://blog.csdn.net/alading2009/article/details/44872143
public class T9_IsSequenceThePostOrder {

    public boolean isSequenceThePostOrder(int[] sequence){
        
        if(null == sequence)
            return false;
        
        return helper(sequence, 0, sequence.length - 1);
    }
    
    public boolean helper(int[] sequence, int left, int right){
        
        if(left >= right)
            return true;
        
        int rootVal = sequence[right];
        int mid = 0;
        //判断左子树是否已遍历完
        boolean flag = false;
        for(int i = left; i < right; i++){
            if(!flag && sequence[i] > rootVal){
                //遍历到右子树的第一个节点
                mid = i;
                flag = true;
            }else if(flag && sequence[i] < rootVal){
                //右子树中有节点小于根节点的值（不符合二叉查找树的性质）
                return false;
            }
        }
        
        return helper(sequence, left, mid - 1) && helper(sequence, mid, right-1);
    }
    
    public static void main(String[] args) {
        T9_IsSequenceThePostOrder t = new T9_IsSequenceThePostOrder();
        int[] sq1 = {5, 7, 6, 9, 11, 10, 8};
        int[] sq2 = {7, 4, 6, 5};
        
        boolean result1 = t.isSequenceThePostOrder(sq1);
        boolean result2 = t.isSequenceThePostOrder(sq2);
        System.out.println(result1 + ", " + result2);
    }
}
