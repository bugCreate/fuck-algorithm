package com.heming.learn.leetcode.list;
// hash 基础做法
// bit 位运算
// 1和3 的公倍数为3
// 存在所有数的第i位不能被3 整除，说明这个位置x 的第i位为1
public class LeetCode_137 {
    public int singleNumber(int[] nums) {
        int ans =0;
        for (int i=0;i<32;i++){
            int total=0;
            for (int num : nums) {
                total+=((num>>i)&1);
            }
            if (total%3!=0){
                ans|=(1<<i);
            }
        }
        return ans;
    }
}
