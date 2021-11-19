package com.heming.learn.leetcode.tree.bintree;

public class LeetCode_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        int subNum = targetSum - root.val;
        if (isLeef(root)) {
            return subNum==0;
        }
        boolean result = hasPathSum(root.left, subNum);
        if (!result){
            result= hasPathSum(root.right,subNum);
        }
        return result;
    }

    private boolean isLeef(TreeNode root) {
        return root.left==null && root.right== null;
    }
}
