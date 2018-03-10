package exercise.algorithm.microsoft100;

/*
第10题（字符串）
翻转句子中单词的顺序。
题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。

句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。
例如输入“I am a student.”，则输出“student. a am I”。
*/
public class T10_ReverseStrExceptWords {

    /*
     * 在何海涛的日记中，分析方法是: 先颠倒句子中的所有字符。这时，不但翻转了句子中单词的顺序，而且单词内字符也被翻转了。
     * 我们再颠倒每个单词内的字符。由于单词内的字符被翻转两次，因此顺序仍然和输入时的顺序保持一致。
     */
    //这种方法太复杂，可以考虑用栈或者容器来保存分隔后的单词，再进行逆序拼接
    //https://www.cnblogs.com/hustcser/p/4118825.html
    
    
    //这里使用StringBuilder来进行处理
    //String, StringBuilder, StringBuffer的区别：https://www.cnblogs.com/su-feng/p/6659064.html
    public String reverseStrExceptWords(String str){
        if(null == str)
            return null;
        
        String[] wordArray = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = wordArray.length - 1; i >= 0; i--){
            if(i == 0){
                sb.append(wordArray[i]);
            }else{
                sb.append(wordArray[i] + " ");
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        T10_ReverseStrExceptWords t = new T10_ReverseStrExceptWords();
        String str = "I am a Student.";
        String result = t.reverseStrExceptWords(str);
        System.out.println(result);
    }
}
