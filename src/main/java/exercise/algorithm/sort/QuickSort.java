package exercise.algorithm.sort;

import java.util.Random;

/*
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] nums, int start, int end) throws Exception{
        if(start == end)
            return;
        
        int index = partition(nums, start, end);
        
        if(index > start){
            quickSort(nums, start, index - 1);
        }
        
        if(index < end){
            quickSort(nums, index + 1, end);
        }
    }
    
    
    public static int partition(int[] nums, int start, int end) throws Exception{
        if(nums == null || nums.length <= 0 || start < 0 || end >= nums.length){
            throw new Exception("Invalid Parameter");
        }
        
        int index = RandomInRange(start, end);
        swap(nums, index, end);
        
        int small = start - 1;
        
        for(index = start; index < end; index++){
            if(nums[index] < nums[end]){
                small++;
                if(small != index){
                    swap(nums, small, index);
                }
            }
        }
        
        small++;
        swap(nums, small, end);
        
        return small;
        
    }
    
    /**
     * 
     * @param start
     * @param end
     * @return [start, end]之间的一个随机数
     */
    public static int RandomInRange(int start, int end){
        Random rand = new Random();
        int result = rand.nextInt(end - start + 1) + start;
        return result;
    }
    
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) throws Exception {
        int[] nums = {20, 10, 90, 30, 70, 40, 80, 60, 50};
        quickSort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
