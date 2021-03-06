package com.heming.learn.leetcode.list;

public class LeetCode_026 {
    public int removeDuplicates(int[] nums) {

        int slow=0;
        for (int i=1;i<nums.length; i++) {
           if (nums[i]!=nums[slow]){
               nums[++slow]=nums[i];
           }
        }
        return slow+1;
    }
}
