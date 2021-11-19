package com.heming.learn.leetcode.tree.bintree;

public class LeetCode_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depth = isBalancedAndDepth(root);
        return depth >= 0;

    }

    // 判断树是否平衡并返回高度。高度小于0不平衡
    private int isBalancedAndDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = isBalancedAndDepth(root.left);
        if (left < 0) {//左子树不是平衡
            return -1;
        }
        int right = isBalancedAndDepth(root.right);
        if (right < 0) {//右子树不是平衡
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
