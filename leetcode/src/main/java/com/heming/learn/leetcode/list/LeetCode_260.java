package com.heming.learn.leetcode.list;

public class LeetCode_260 {
    public int[] singleNumber(int[] nums) {
        int aWithB =0;
        for (int num : nums) {
            aWithB=aWithB^num;
        }
        int lsb=(aWithB==Integer.MIN_VALUE?aWithB:aWithB&(-aWithB));
        int a=0,b=0;
        for (int num : nums) {
            if ((num&lsb)==0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};

    }
}
