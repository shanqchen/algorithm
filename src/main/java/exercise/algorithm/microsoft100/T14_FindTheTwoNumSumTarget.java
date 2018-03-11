package exercise.algorithm.microsoft100;

import java.util.HashMap;
import java.util.Map;

/*
第14题（数组）：
题目：输入一个已经按升序排序过的数组和一个数字，
在数组中查找两个数，使得它们的和正好是输入的那个数字。
要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
*/
public class T14_FindTheTwoNumSumTarget {

    //ref: https://www.cnblogs.com/dplearning/p/3895217.html
    public boolean findTheTarget(int[] nums, int target){
        //双指针
        int low = 0, high = nums.length - 1;
        while(low < high){
            if(target == nums[low] + nums[high]){
                //find
                System.out.println(nums[low] + ", " + nums[high]);
                return true;
            }else if(target < nums[low] + nums[high]){
                high--;
            }else{
                low++;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        T14_FindTheTwoNumSumTarget t = new T14_FindTheTwoNumSumTarget();
        int target = 15;
        int[] nums = {1, 2, 4, 7, 11, 15};
        boolean result = t.findTheTarget(nums, target);
        System.out.println(result);
    }
}
