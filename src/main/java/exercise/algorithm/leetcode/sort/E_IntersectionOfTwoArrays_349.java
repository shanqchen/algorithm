package exercise.algorithm.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E_IntersectionOfTwoArrays_349 {

    /**
     * 常规方法：使用一个set保存第一个数组，另外创建一个set用来保存交集，
     * 然后遍历第二个数组，将第二个数组中在set中能找到的元素存入交集set,
     * 最后将交集set转为数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2){
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> interSet = new HashSet<>();
        
        for(int i = 0; i < nums1.length; i++){
            numSet.add(nums1[i]);
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(numSet.contains(nums2[i])){
                interSet.add(nums2[i]);
            }
        }
        
        int[] result = new int[interSet.size()];
        
        int index = 0;
        for(Integer num : interSet){
            result[index++] = num;
        }
        
        return result;
    }
    
    /**
     * 方法二：排序
     * 1. 先将nums1, nums2分别排序
     * 2. 用两个指针同时遍历两个数组，哪个值小则指针前进；
     *    如果两个值相等，且结果集的最后一个数不等于该值，则将该值放入结果集中
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                if(list.isEmpty() || list.get(list.size() - 1) != nums1[i]){
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        
        int[] result = new int[list.size()];
        int index = 0;
        for(Integer num : list){
            result[index++] = num;
        }
        
        return result;
    }
    
    /**
     * 方法三：二分查找
     * 1. 将其中一个数组1进行排序
     * 2. 遍历另一个数组2，在已排序的数组1中二分查找数组2中的每一个元素，如果找到，则存入一个集合中
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection3(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        
        for(int num : nums2){
            if(binarySearch(nums1, num)){
                set.add(num);
            }
        }
        
        int[] result = new int[set.size()];
        int index = 0;
        for(Integer num : set){
            result[index++] = num;
        }
        
        return result;
    }
    
    //二分查找
    public static boolean binarySearch(int[] nums, int target){
        if(null == nums || nums.length == 0)
            return false;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
    
    
    
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1,2};
        intersection3(nums1, nums2);
    }
    
}
