package com.heming.learn.leetcode;

public class LeetCode_326 {
    public boolean isPowerOfThree(int n) {
        if (n<=0){
            return false;
        }
        int threeP=1;
        while (threeP<n&& threeP>0){

                threeP*=3;


        }
        return threeP==n;
    }
}
