package exercise.algorithm.microsoft100;

/*
 * 第20题（字符串）：
题目：输入一个表示整数的字符串，把该字符串转换成整数并输出。
例如输入字符串"345"，则输出整数345。
 */

//乍一看只要考虑"345"如何转换为数字345就行了，但其实我们应该考虑正负数、有效数字（只有正负号、空字符串、中间含非数字字符的字符串）、转换后的数字是否溢出等情况
//ref: https://blog.csdn.net/evan123mg/article/details/45459781
public class T_20_StringToNumbers {

    //我们可以参考Java自带的int Integer.parseInt(String s)方法
    public int StringToInt(String str) throws MyException {
        if(null == str){
            throw new MyException("字符串为空");
        }
        
        int len = str.length();
        int offset = 0;
        int limit = -Integer.MAX_VALUE;
        int multMin;
        int digit;
        int result = 0;
        boolean negative = false;
        
        if(len > 0){
            char firstChar = str.charAt(offset);
            if(firstChar < '0'){
                //可能为'+' or '-'
                if(firstChar == '-'){
                    negative = true;
                    limit = Integer.MIN_VALUE;
                }else if(firstChar != '+'){
                    throw new MyException("非法字符串");
                }
                
                if(len == 1){
                    throw new MyException("非法字符串, 不能只有+或-");
                }
                
                offset++;
            }
            
            multMin = limit/10;
            
            char[] charArr = str.toCharArray();
            for(int i = offset; i < len; i++){
                if(charArr[i] >= '0' && charArr[i] <= '9'){
                    digit = charArr[i] - '0';
                    if(result < multMin){
                        throw new MyException("溢出");
                    }
                    result *= 10;
                    if(result < limit + digit){
                        throw new MyException("溢出");
                    }
                    result -= digit;
                }else{
                    throw new MyException("存在非数字字符");
                }
            }
        }else{
            throw new MyException("字符串长度为0");
        }
        
        return negative ? result : -result;
        
    }
    
    
    public static void main(String[] args) {
        
        /* 参考值
        int minRadix = Character.MIN_RADIX;
        int maxRadix = Character.MAX_RADIX;
        System.out.println(minRadix + "-" + maxRadix);  //2-36
        
        int max = Integer.MIN_VALUE/10;        //-214748364
        System.out.println(Integer.MIN_VALUE); //-2147483648 = -2^31
        System.out.println(Integer.MAX_VALUE); // 2147483647 = 2^31 - 1
        System.out.println(Integer.MAX_VALUE + 1); //-2147483648
        System.out.println(max);
        
        String str = "345";
        //If the radix is not in the range MIN_RADIX ≤ radix ≤ MAX_RADIX 
        //or if the value of ch is not a valid digit in the specified radix, -1 is returned. 
        int digit = Character.digit(str.charAt(0), 10);
        System.out.println(digit);             // 3
        */
        
        T_20_StringToNumbers t = new T_20_StringToNumbers();
        String str = "345";
//        String str = "-345";
//        String str = "+345";
//        String str = "+";
//        String str = "-";
//        String str = "";        //字符串长度为0
//        String str = null;      //字符串为空
//        String str = "34t5";    //存在非数字字符
//        String str = "3451111111111111111111111111111111111111111111111111111111111111111";           //溢出

        try {
            int result = t.StringToInt(str);
            System.out.println(result);
        } catch (MyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class MyException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = -3862163670604979597L;
    
    private String message;
    
    public MyException(String msg){
        super();
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
    
}
