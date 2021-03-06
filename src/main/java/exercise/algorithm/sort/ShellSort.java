package exercise.algorithm.sort;

/**
 * 希尔排序
 * 思想：希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，
 * 每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 * ref: https://www.cnblogs.com/chengxiao/p/6104371.html
 */
public class ShellSort {

    public static void shellSort(int[] nums){
        if(null != nums){
            //增量gap，并逐步缩小增量
            for(int gap = nums.length/2; gap > 0; gap/=2){
                //从第gap个元素，逐个对其所在组进行直接插入排序操作
                for(int i = gap; i < nums.length; i++){
                    
                    int j = i;
                    while(j-gap >= 0 && nums[j] < nums[j-gap]){
                        //交换法
                        SortUtil.swap(nums, j, j-gap);
                        j -= gap;
                    }
                }
            }
        }
    }
    
    public static void shellSort2(int[] nums){
        if(null != nums){
            for(int gap = nums.length/2; gap > 0; gap/=2){
                
                for(int i = gap; i < nums.length; i++){
                    
                    int j = i;
                    int target = nums[j];
                    
                    while(j-gap >= 0 && target < nums[j-gap]){
                        //移动法
                        nums[j] = nums[j-gap];
                        j -= gap;
                    }
                    nums[j] = target;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 7, 2, 3, 5, 6, 0};
        SortUtil.print(nums);
        shellSort(nums);
        SortUtil.print(nums);
    }
}
