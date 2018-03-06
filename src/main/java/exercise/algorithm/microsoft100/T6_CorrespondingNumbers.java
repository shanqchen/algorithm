package exercise.algorithm.microsoft100;

/*
第6题（数组）
腾讯面试题： 
给你10分钟时间，根据上排给出十个数，在其下排填出对应的十个数 
要求下排每个数都是先前上排那十个数在下排出现的次数。 
上排的十个数如下： 
【0，1，2，3，4，5，6，7，8，9】

举一个例子， 
数值: 0,1,2,3,4,5,6,7,8,9 
分配: 6,2,1,0,0,0,1,0,0,0 
0在下排出现了6次，1在下排出现了2次， 
2在下排出现了1次，3在下排出现了0次.... 
以此类推..
*/
public class T6_CorrespondingNumbers {

    //分治法
    //ref: http://www.xuebuyuan.com/1155391.html
    /*
                以上面的例子为例:
      0在下排出现了6次,即下排有6个0,有2个1,有1个2,有1个6.
                仔细观察,可以发现一个共同点:
                对于一个数组A[n],下排的数字总和为n.
                可以由之前的字符的全排列中找到灵感.
                因此可以定义一个函数ArrayF(int* A,int n,int Sum),这个函数的功能是:使得A[0]+A[1]+A[2]+….+A[n-1]=Sum.其中A[i]=m,i=0,1,2,3….n-1,0<m<n-1.
                这样子就可以用分治法来解决这个问题了.
    */
    public void arrayF(int[] nums, int n, int sum){
        if(null == nums || n < 1 || sum < 1)
            return;
        
        if(n == 1){
            nums[0] = sum;
            if(isLegal(nums)){
                for(int i = 0; i < nums.length; i++){
                    System.out.print(nums[i] + " ");
                }
                System.out.println();
            }
        }else{
            for(int i = 0; i < sum; i++){
                nums[n - 1] = i;
                arrayF(nums, n - 1, sum - i);
            }
        }
    }
    
    //判断下面的排列是否满足需求
    public boolean isLegal(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(i == nums[j]){
                    ++count;
                }
            }
            if(nums[i] != count){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        T6_CorrespondingNumbers t = new T6_CorrespondingNumbers();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] target = new int[nums.length];
        int sum = 10;   //nums中数的总数
        for(int i = 0; i < nums.length; i++){
            target[i] = nums[i];
        }
        t.arrayF(target, target.length, sum);
    }
}
