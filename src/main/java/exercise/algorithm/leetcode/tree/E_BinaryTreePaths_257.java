package exercise.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class E_BinaryTreePaths_257 {
    
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root){
        if(null == root)
            return result;
        helper(root, "" + root.val);
        
        return result;
    }
    
    public void helper(TreeNode root, String str){
        if(null == root.left && null == root.right){
            result.add(str);
            return;
        }
        if(null != root.left){
            helper(root.left, str + "->" + root.left.val);
        }
        if(null != root.right){
            helper(root.right, str + "->" + root.right.val);
        }
    }
}
