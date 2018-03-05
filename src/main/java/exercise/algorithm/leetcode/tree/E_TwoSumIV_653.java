package exercise.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class E_TwoSumIV_653 {

    //refer: https://www.cnblogs.com/grandyang/p/7508169.html
    //recursive
    public static boolean findTarget(TreeNode root, int k) {
        if(null == root) return false;
        
        Set<Integer> elemSet = new HashSet<>();
        
        return helper(root, k, elemSet);
    }
    
    public static boolean helper(TreeNode node, int k, Set<Integer> elemSet){
        if(null == node) return false;
        
        if(elemSet.contains(k - node.val)) return true;
        
        elemSet.add(node.val);
        return (helper(node.left, k, elemSet) || helper(node.right, k, elemSet));
    }
    
    
    public static boolean findTargetIterationBeta(TreeNode root, int k) {
        if(null == root) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> elemSet = new HashSet<>();
        q.offer(root);
        elemSet.add(root.val);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(null != node.left){
                if(elemSet.contains(k - node.left.val)){
                    return true;
                }else{
                    elemSet.add(node.left.val);
                    q.offer(node.left);
                }
            }
            if(null != node.right){
                if(elemSet.contains(k - node.right.val)){
                    return true;
                }else{
                    elemSet.add(node.right.val);
                    q.offer(node.right);
                }
            }
        }
        return false;
    }
    
    /**
     * 针对beta版，进行了精简
     * @param root
     * @param k
     * @return
     */
    public static boolean findTargetIteration(TreeNode root, int k) {
        if(null == root) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> elemSet = new HashSet<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(elemSet.contains(k - tmp.val)){
                return true;
            }
            elemSet.add(tmp.val);
            if(null != tmp.left)
                q.offer(tmp.left);
            if(null != tmp.right)
                q.offer(tmp.right);
        }
        
        return false;
    }
    
    //Approach #3 Using BST
    //二次搜索树经中序遍历后是一个升序序列
    //我们用一个List存储中序序列，然后用双指针法确定目标是否在序列元素之和中
    //refer: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/solution/
    public static boolean findTargetList(TreeNode root, int k){
        if(null == root) return false;
        
        List<Integer> list = new ArrayList<>();
        inOrderBST(root, list);
        
        int l = 0, r = list.size() - 1;
        while(l < r){
            int sum = list.get(l) + list.get(r);
            if(sum == k){
                return true;
            }else if(sum > k){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }
    
    public static void inOrderBST(TreeNode root, List<Integer> list){
        if(null == root) return;
        
        inOrderBST(root.left, list);
        list.add(root.val);
        inOrderBST(root.right, list);
    }
    
    public static void main(String[] args) {
        int[] preOrder = {5, 3, 2, 4, 6, 7};
        int[] inOrder = {2, 3, 4, 5, 6, 7};
        
        TreeNode bst = TreeUtils.ConstructBinaryTree(preOrder, inOrder);
//        boolean result = findTargetIteration(bst, 10);
//        boolean result = findTarget(bst, 28);
        boolean result = findTargetList(bst, 9);
        System.out.println(result);
    }
}
