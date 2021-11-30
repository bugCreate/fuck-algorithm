package com.heming.learn.leetcode.list;

public class LeetCode_268
{
    public int missingNumber(int[] nums) {
        int rightTotal = ((nums.length+1)*nums.length)/2;
        int curtotal=0;
        for (int num : nums) {
            curtotal+=num;
        }
        return rightTotal-curtotal;
    }
}
