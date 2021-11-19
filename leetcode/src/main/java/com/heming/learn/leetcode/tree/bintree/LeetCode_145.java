package com.heming.learn.leetcode.tree.bintree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}
