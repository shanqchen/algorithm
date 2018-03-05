package exercise.algorithm.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E_IntersectionOfTwoArraysII_350 {

    /**
     * 方法一：双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        
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
                list.add(nums1[i]);
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
     * 方法二：
     */
    public static int[] intersect2(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums1){
            if(countMap.containsKey(num) == false){
                countMap.put(num, 1);
            }else{
                countMap.put(num, countMap.get(num) + 1);
            }
        }
        for(int num : nums2){
            if(countMap.containsKey(num)){
                if(countMap.get(num) > 0){
                    list.add(num);
                    countMap.put(num, countMap.get(num) - 1);
                }
            }
        }
        
        int[] result = new int[list.size()];
        int index  = 0;
        for(int num : list){
            result[index++] = num;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect2(nums1, nums2);
    }
}
