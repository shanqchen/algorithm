package exercise.algorithm.leetcode.sort;

import java.util.Arrays;

//anagram(变位词): 由变换某个词或短语的字母顺序而构成的新的词或短语。例如，"triangle"是"integral"的变位词。
public class E_ValidAnagram_242 {

    /**
     * 方法一：如果s和t排序后值相等，则它们互为anagram
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t){
        if(null == s || null == t)
            return false;
        if(sortString(s).equals(sortString(t))){
            return true;
        }
        return false;
    }
    
    public static String sortString(String str){
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        String sortedStr = new String(chs);
        return sortedStr;
    }
    
    /**
     * 方法二：哈希计数法（用数组代替哈希表）
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t){
        if(null == s || null == t)
            return false;
        if(s.length() != t.length())
            return false;
        //只有26个小写字母，所以数组长度声明为26
        int[] count = new int[26];
        //对字符串s中的字母进行计数
        for(int i = 0; i < s.length(); i++){
            ++count[s.charAt(i) - 'a'];
        }
        //对字符串t中的元素进行判断
        for(int i = 0; i < t.length(); i++){
            if(--count[t.charAt(i) - 'a'] < 0)
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        boolean result = isAnagram2(s, t);
        System.out.println(result);
    }
}
