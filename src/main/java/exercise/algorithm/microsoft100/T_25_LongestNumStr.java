package exercise.algorithm.microsoft100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
第25题（字符串）：
写一个函数,它的原形是int continumax(char *outputstr,char *intputstr)
功能：
在字符串中找出连续最长的数字串，并把这个串的长度返回，
并把这个最长数字串付给其中一个函数参数outputstr所指内存。
例如："abcd12345ed125ss123456789"的首地址传给intputstr后，函数将返回9，
outputstr所指的值为123456789
*/

//ref: https://blog.csdn.net/pediy_yuhan/article/details/37068023
public class T_25_LongestNumStr {

    public int longestNumStr(String str, List<String> list){
        
        if(null == str){
            return 0;
        }
        
        //添加辅助字符，应对以数字字符结尾的字符串
        str = str + "x";
        
        int maxLen = 0;
        
        int len = 0;
        int start = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                len++;
            }else{
                if(len > maxLen){
                    maxLen = len;
                    start = i - len;
                }
                len = 0; //记得清0
            }
        }
        
        List<String> tmp = Arrays.asList(str.substring(start, start + maxLen));
        for(String s : tmp){
            list.add(s);
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        
        T_25_LongestNumStr t = new T_25_LongestNumStr();
        
        String str = "abcd12345ed125ss123456789";
//        String str = "p123";
        
        List<String> list = new ArrayList<>();
        
        int result = t.longestNumStr(str, list);
        
        System.out.println("最长数字子串长度：" + result);
        System.out.println("最长数字子串为：" + list.toString());
    }
}
