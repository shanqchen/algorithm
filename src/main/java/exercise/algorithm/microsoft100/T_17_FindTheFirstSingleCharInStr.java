package exercise.algorithm.microsoft100;
/*
第17题（字符串）：
题目：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。  
分析：这道题是2006年google的一道笔试题。
 */

//分析：找单个字符出现的次数，考虑用哈希表，由于这里需要找出顺序，所以可以用数组模拟哈希表，
//哈希表的键值为字符的ASCII码值，共256个

//也可以通过split某个String的某个字符，看得到的数组的大小来判断

//https://www.cnblogs.com/wuzetiandaren/p/4261992.html
public class T_17_FindTheFirstSingleCharInStr {

    public char findTheFirstSingleCharInStr(String str){
        int[] charArray = new int[256];
        for(int i = 0; i < str.length(); i++){
            charArray[str.charAt(i)] += 1;
        }
        
        for(int i = 0; i < str.length(); i++){
            if(charArray[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        T_17_FindTheFirstSingleCharInStr t = new T_17_FindTheFirstSingleCharInStr();
        String str = "abaccdeff";
        System.out.println(t.findTheFirstSingleCharInStr(str));
        
        //如果采用split字符来判断该字符在字符串中出现的次数，需要注意字符在末尾的情形
//        String[] arr = str.split("f");  //如果f在末尾，则split得到的数组为["abaccde"],
        //要正确判断f出现的次数，可以在末尾加任意一个字符，比如a,这样split之后,结果为["abaccde", "", "a"]
        //而加上的字符'a'对于str.split("a")的结果则没有影响，仍旧为["", "b", "ccdeff"]
//        System.out.println(arr.length);
    }
    /*
     * output: b
     */
}
