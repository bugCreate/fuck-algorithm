package com.heming.learn.leetcode.dp;

public class LeetCode_1137 {
    public static void main(String[] args) {
        LeetCode_1137 leetCode_1137 = new LeetCode_1137();
        System.out.println(leetCode_1137.tribonacci(4));
    }
    public int tribonacci(int n) {
        int pre0=0;
        int pre1=1;
        int pre2 =1;
        if (n==0){
            return pre0;
        }
        if (n==1){
            return pre1;
        }
        if (n==2){
            return pre2;
        }
        int index =2;
        int result =0;
        while (index<n){
            result=pre0+pre1+pre2;
            pre0=pre1;
            pre1=pre2;
            pre2=result;

            index++;
        }
        return result;
    }
}
