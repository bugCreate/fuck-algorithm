package com.heming.learn.leetcode.tree.bintree;

public class LeetCode_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null ==p && null ==q){
            return true;
        }
        if((null == p || null ==q) || p.val!=q.val){
            return false;
        }
        boolean result= isSameTree(p.left,q.left);
        if (result){
            return isSameTree(p.right,q.right);

        }
        return false;
    }
}
