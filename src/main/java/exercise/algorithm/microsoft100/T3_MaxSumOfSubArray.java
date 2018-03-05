package exercise.algorithm.microsoft100;

/*
3.求子数组的最大和（数组）
题目：
输入一个整形数组，数组里有正数也有负数。
数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
求所有子数组的和的最大值。要求时间复杂度为O(n)。

例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
因此输出为该子数组的和18。
*/
public class T3_MaxSumOfSubArray {

    //动态规划
    //ref: http://blog.csdn.net/martin_liang/article/details/38798839
    //以第i个元素结尾的子数组的最大和可以由它之前的以第i-1个元素结尾的子数组的最大和推导出。
    //如果以i-1结尾子数组的最大和d[i-1]>0,那么d[i-1]+a[i]则就是d[i]，如果d[i-1]<0,则以i元素结尾的最大子数组最大和就是a[i]了。
    //那么如果数组从头到尾以每个位置元素结尾的子数组的最大和都有了，只要比较得到其中最大的值，那么就是这个数组子数组最大和的值。
    /**
     * nums:{1, -2, 3, 10, -4, 7, 2, -5}
     * 设d[i]为以a[i]为末尾的最大子数组和
     * 则：
     * d[0] = a[0] = 1;
     * d[1] = max{d[0] + a[1], a[1]} = max{1 + (-2), -2} = -1;
     * d[2] = max{d[1] + a[2], a[2]} = max{-1 + 3, 3} = 3;
     * ...
     * d[i] = max{d[i-1] + a[i], a[i]} (i > 0)
     * @param nums
     * @return
     */
    public int maxSumOfSubArray(int[] nums){
        
        if(null == nums || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if(maxSum < dp[i]){
                maxSum = dp[i];
            }
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        T3_MaxSumOfSubArray t = new T3_MaxSumOfSubArray();
//        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] nums = {-6, -2, -3, -10, -4, -7, -2, -5};
        int maxSum = t.maxSumOfSubArray(nums);
        System.out.println(maxSum);
    }
}
