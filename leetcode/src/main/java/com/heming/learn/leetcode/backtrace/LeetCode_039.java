package com.heming.learn.leetcode.backtrace;

import java.util.*;

public class LeetCode_039 {
    public static void main(String[] args) {
        int[] c = new int[]{2, 3, 6, 7};
        LeetCode_039 leetCode_039 = new LeetCode_039();
        System.out.println(leetCode_039.combinationSum(c, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, target, 0);
    }

    public List<List<Integer>> dfs(int[] candidates, int target, int min) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        if (target < 0) {
            return null;
        }

        for (int candidate : candidates) {
            if (candidate<min){
                continue;
            }
            List<List<Integer>> subReuslt = dfs(candidates, target - candidate, candidate);
            if (subReuslt == null) {
                continue;
            }
            for (List<Integer> sub : subReuslt) {
                sub.add(candidate);
                result.add(sub);
            }
        }
        return result;
    }
}
