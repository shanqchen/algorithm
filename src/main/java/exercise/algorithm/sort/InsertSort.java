package exercise.algorithm.sort;
/**
 * 插入排序
 * ref1: https://www.cnblogs.com/xiaoming0601/p/5862793.html
 * ref2: https://www.cnblogs.com/shihaokiss/p/5449011.html
 * keyword: in-place排序，稳定
 * 复杂度：
 *      -空间复杂度：O(1)
 *      -时间复杂度：O(n^2)
 *      -最好情况：正序，不需要移动元素
 *      -最坏情况：逆序，需移动n*(n-1)/2次元素
 *      -数组在已排序或者“近似排序”时，插入排序效率最好的运行情况为O(n)
 *      -拓展：希尔排序（分组插入排序）
 */
public class InsertSort {

    public static void insertSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        int i, j;
        int target;
        for(i = 1; i < nums.length; i++){
            j = i;
            target = nums[i];
            while(j > 0 & nums[j] < nums[j - 1]){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = target;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,4,7,9};
        SortUtil.print(nums);
        insertSort(nums);
        SortUtil.print(nums);
    }
}
