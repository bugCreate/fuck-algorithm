package com.heming.learn.leetcode.backtrace;


import com.heming.learn.leetcode.tree.bintree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> trace = new LinkedList<>();
        backTrace(root,targetSum,trace,result);
        return result;
    }

    private void backTrace(TreeNode root, int targetSum,LinkedList<Integer> trace, List<List<Integer>> result) {
        if (null ==root){//节点为空，停止
            return;
        }
        trace.addLast(root.val);// 加入路径
        if (isLeef(root)){// 是叶子节点
            if (targetSum==root.val){// 符合目标，加入结果
                result.add(new LinkedList<>(trace));
            }
        }else {
            int nextTarget = targetSum-root.val;
            backTrace(root.left,nextTarget,trace,result);
            backTrace(root.right,nextTarget,trace,result);
        }
        trace.removeLast();// 回退

    }

    private boolean isLeef(TreeNode root) {
        return root.left==null && root.right==null;
    }

}
