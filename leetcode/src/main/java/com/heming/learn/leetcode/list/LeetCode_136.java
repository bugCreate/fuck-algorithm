package com.heming.learn.leetcode.list;

public class LeetCode_136 {
    public int singleNumber(int[] nums) {
        int ans=0;
        for (int num : nums) {
            ans^=num;
        }
        return ans;
    }
}
