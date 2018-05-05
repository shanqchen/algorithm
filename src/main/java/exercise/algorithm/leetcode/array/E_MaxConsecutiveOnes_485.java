package exercise.algorithm.leetcode.array;

//https://leetcode.com/problems/max-consecutive-ones/description/
//The input array will only contain 0 and 1
//The length of input array is a positive integer and will not exceed 10,000
public class E_MaxConsecutiveOnes_485 {

    /*
     * 方法一：遍历累加计数
     */
    public static int findMaxConsecutiveOnes(int[] nums){
        int max = 0;
        int cnt = 0;
        for(Integer num : nums){
            cnt = (num == 0) ? 0 : cnt + 1;
            max = Math.max(max, cnt);
        }
        return max;
    }
    
    /**
     * 因为元素只可能为0或者1，所以连续1的和和连续1的个数相等，用这个和乘以num,如果当前数字是0，则和被置0
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes2(int[] nums){
        int sum = 0, res = 0;
        for(Integer num : nums){
            sum = (sum + num)*num;
            res = Math.max(res, sum);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,1,0,0,1,1,1,1};
//        int[] nums = {0,0,0,0,0,0,0,0};
        int result = findMaxConsecutiveOnes2(nums);
        System.out.println(result);
    }
}
