package com.heming.learn.leetcode.backtrace;

import com.heming.learn.leetcode.tree.bintree.TreeNode;

import java.util.*;

public class LeetCode_095 {

    Map<String, List<TreeNode>> dpTable = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = dp(1, n);
        return result;
    }

    private List<TreeNode> dp(int from, int end) {
        if (from > end) {
            return Collections.singletonList(null);
        }
        List<TreeNode> allTrees = new ArrayList<>();
        for (int i = from; i <= end; i++) {
            String leftKey = from + "-" + (i - 1);
            List<TreeNode> left;
            if (dpTable.containsKey(leftKey)) {
                left = dpTable.get(leftKey);
            } else {
                left = dp(from, i - 1);
                dpTable.put(leftKey, left);
            }
            String rightKey = from + "-" + (i - 1);
            List<TreeNode> right;
            if (dpTable.containsKey(rightKey)) {
                right = dpTable.get(rightKey);
            } else {
                right = dp(i + 1, end);
                dpTable.put(leftKey, right);
            }
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = l;
                    currTree.right = r;
                    allTrees.add(currTree);
                }
            }

        }
        return allTrees;
    }
}
