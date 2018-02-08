package exercise.algorithm.leetcode.tree;

public class E_ConstructStringFromBinaryTree_606 {

    /*
          该方法得不得正确结果：
    1.对象就是传引用
    2.原始类型就是传值
    3.String，Integer, Double等immutable类型因为没有提供自身修改的函数，
           每次操作都是新生成一个对象，所以要特殊对待。可以认为是传值。
    Integer 和 String 一样。保存value的类变量是Final属性，无法被修改，
          只能被重新赋值／生成新的对象。 当Integer 做为方法参数传递进方法内时，
          对其的赋值都会导致 原Integer 的引用被 指向了方法内的栈地址，失去了对原类变量地址的指向。
          对赋值后的Integer对象做得任何操作，都不会影响原来对象。
    */
    //https://segmentfault.com/q/1010000004659821?_ea=682618
    @Deprecated
    public static String tree2str(TreeNode t) {
        if(null == t) return "";
        
        String str = "";
        helper(t, str);
        return str.substring(1, str.length() - 1);
    }
    
    @Deprecated
    public static void helper(TreeNode t, String str){
        if(null == t) return;
        
        str += "(" + t.val;
        
        if(null == t.left && null != t.right)
            str += "()";
        helper(t.left, str);
        helper(t.right, str);
        
        str += ")";
    }
    
    public static String tree2str2(TreeNode t) {
        if(null == t) return "";
        
        String str = "";
        str = helper2(t, str);
        return str.substring(1, str.length() - 1);
    }
    
    public static String helper2(TreeNode t, String str){
        if(null == t) return str;
        
        str += "(" + t.val;
        if(null == t.left && null != t.right)
            str += "()";
        str = helper2(t.left, str);
        str = helper2(t.right, str);
        
        str += ")";
        
        return str;
    }
    
    //method II: 中序递归遍历
    /*
    Input: Binary tree: [1,2,3,null,4]
            1
          /   \
         2     3
          \  
           4 

     Output: "1(2()(4))(3)"
     
             根据Output的特点：X = 2()(4), Output = 1(X)(3)
             对于3和4，写为3()(), 4()().双括号或右括号可以省略
     */
    public static String tree2str3(TreeNode t){
        
        if(null == t) return "";
        
        String str = "" + t.val;
        
        if(null == t.left && null == t.right)
            return str;
        
        str += "(" + tree2str2(t.left) + ")";
        
        if(null != t.right){
            str += "(" + tree2str2(t.right) + ")";
        }
        
        return str;
        
        
    }
    
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 3};
        int[] inOrder = {2, 4, 1, 3};
        
        TreeNode bt = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
        
        String str2 = tree2str2(bt);
        String str3 = tree2str3(bt);
        System.out.println(str2);
        System.out.println(str3);
    }
}
