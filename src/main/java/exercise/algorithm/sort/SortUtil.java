package exercise.algorithm.sort;

public class SortUtil {

    public static void print(int[] nums){
        if(null != nums){
            for(int i = 0; i < nums.length; i++){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}
