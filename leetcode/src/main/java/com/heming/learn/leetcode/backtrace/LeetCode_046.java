package com.heming.learn.leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_046 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        LeetCode_046 leetCode_046 = new LeetCode_046();
        System.out.println(leetCode_046.permute(nums));
    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        result.clear();
        LinkedList<Integer> trace= new LinkedList<>();
        backTrace(nums,trace);
        return result;
    }

    private void backTrace(int[] nums, LinkedList<Integer> trace) {
        if (trace.size()== nums.length){
            result.add(new LinkedList<>(trace));
            return;
        }
        for (int num : nums) {
            if (trace.contains(num)) {
                continue;
            }
            trace.addLast(num);
            backTrace(nums, trace);
            trace.removeLast();
        }
    }
}
