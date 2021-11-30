package com.heming.learn.leetcode.dp;

import java.util.*;
// dsp 时间超限
public class LeetCode_055 {
    private static Map<Integer, Boolean> dpTable = new HashMap<>();

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3};
        LeetCode_055 leetCode_055= new LeetCode_055();
        System.out.println(leetCode_055.canJump(num));
    }
    public boolean canJump(int[] nums) {
        dpTable.clear();
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        return dp(nums, nums.length - 1);
    }

    private boolean dp(int[] num, int index) {
        if (index == 0) {
            return true;
        }
        boolean result = false;
        List<Integer> posible= new ArrayList<>();
        for (int i = index - 1; i >= 0; i--) {
            // 可能到达的
            if (num[i]+i>=index){
                posible.add(i);
            }
        }
        for (Integer integer : posible) {
            if (dpTable.containsKey(integer)) {
                return dpTable.get(integer);
            } else {
                result = dp(num, integer);
                if (result) {
                    return result;
                } else {
                    dpTable.put(integer, false);
                }
            }
        }
        return false;
    }
    public boolean canJump2(int[] nums) {
        int maxReach=0;
        for (int i=0;i<nums.length;i++) {
            if (i<=maxReach){
                maxReach=Math.max(maxReach,nums[i]+i);
                if (maxReach>=nums.length-1){
                    return true;
                }
            }else {
                break;
            }
        }
        return false;
    }
}
