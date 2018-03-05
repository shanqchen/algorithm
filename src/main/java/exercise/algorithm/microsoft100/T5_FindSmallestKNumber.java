package exercise.algorithm.microsoft100;

/*
5.查找最小的k个元素（数组）
题目：输入n个整数，输出其中最小的k个。
例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
*/
public class T5_FindSmallestKNumber {

    //方法一：对数组进行排序，然后选前K个数
    //快速排序 refer: http://blog.csdn.net/sunlanchang/article/details/60478814
    public void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pivot = partition1(nums, low, high);
            quickSort(nums, low, pivot-1);
            quickSort(nums, pivot+1, high);
        }
    }
    
    public int partition(int[] nums, int low, int high){
        int pivotKey = nums[low];
        while(low < high){
            while(low < high && nums[high] >= pivotKey){
                high--;
            }
            swap(nums, low, high);
            
            while(low < high && nums[low] <= pivotKey){
                low++;
            }
            swap(nums, low, high);
        }
        
        return low;
    }
    
    //优化partition 三数取中
    public int partition1(int[] nums, int low, int high){
        getMedianIn3(nums, low, high);
        int pivotKey = nums[low];
        while(low < high){
            while(low < high && nums[high] >= pivotKey)
                high--;
            nums[low] = nums[high]; //采用替换而不是交换的方式进行操作
            
            while(low < high && nums[low] <= pivotKey)
                low++;
            nums[high] = nums[low];
        }
        
        nums[low] = pivotKey;
        
        return low;
    }
    
    public void getMedianIn3(int[] nums, int low, int high){
        int mid = low + (high - low)/2;
        if(nums[low] > nums[high]){
            swap(nums, low, high);
        }
        
        if(nums[mid] > nums[high]){
            swap(nums, mid, high);
        }
        
        if(nums[mid] > nums[low]){
            swap(nums, mid, low);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        
        int[] nums = {2, 1, 3, 4, 5, 6, 7, 8};
        T5_FindSmallestKNumber t = new T5_FindSmallestKNumber();
        t.quickSort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        
        int p = t.search_k(nums, 0, nums.length - 1, 4);
        for(int i = 0; i < p; i++){
            System.out.print(nums[i] + " ");
        }
    }
    
    //方法二：利用快速排序的思想查找第k小的数或者最小的K个数，主要的核心思想还是快速排序的分治算法，具体的思路是这样的：
    //1 利用快排的partion函数将数组分成左右两个部分，
    //2  如果p刚好等于k，则说明p位置的数，就是我们要找的数，如果分出来的边界位置p小于给定的数k，我们知道最小的第k个数，肯定在p的右边，如果p大于给定的k则在p边界的左边
    //3 递归在p的左边或者右边查找
    //注：p为数组下标需要加1，一般会使用随机数，即在数组中随机选取一个数作为每次分边界的值。
    //refer: http://blog.csdn.net/qingtianweichong/article/details/8960067
    public int search_k(int[] nums, int low, int high, int k){
        int p = partition1(nums, low, high);
        int q = p + 1;
        if(q == k){
            return q;
        }else if(q < k){
            return search_k(nums, p + 1, high, k);
        }else{
            return search_k(nums, low, p - 1, k);
        }
    }
}
