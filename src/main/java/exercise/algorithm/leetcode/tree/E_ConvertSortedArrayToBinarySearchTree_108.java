package exercise.algorithm.leetcode.tree;

public class E_ConvertSortedArrayToBinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode bst = sortedArrayToBST(nums, 0, nums.length - 1);
        return bst;
    }
    
    //利用二叉搜索树中序遍历为一个升序序列，选取中间节点作为二叉搜索树的根
    //则中间节点左边的序列为左子树，右边序列为右子树，如此递归二分查找
    public TreeNode sortedArrayToBST(int[] nums, int low, int high){
        if(low > high)
            return null;
        
        int mid = (low + high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, low, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, high);
        return root;
    }
    
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        E_ConvertSortedArrayToBinarySearchTree_108 c = new E_ConvertSortedArrayToBinarySearchTree_108();
        TreeNode bst = c.sortedArrayToBST(nums);
        TreeUtils.inOrderTraverse(bst);
        System.out.println();
        TreeUtils.preOrderTraverse(bst);
    }
}
