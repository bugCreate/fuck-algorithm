package com.heming.learn.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_070 {
    /**
     * 1 1
     * 2 2
     * 3 3
     * 4 5
     * 第一步可以是1或者2
     * f(n)=f(n-1)+f(n-2)
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    Map<Integer, Integer> dpTable = new HashMap<Integer, Integer>();

    public int climbStairs1(int n) {
        if (n == 1) {
            dpTable.put(1, 1);
            return 1;
        }
        if (n == 2) {
            dpTable.put(2, 2);
            return 2;
        }
        int result = dpTable.containsKey(n - 1) ? dpTable.get(n - 1) : climbStairs1(n - 1) + (dpTable.containsKey(n - 2) ? dpTable.get(n - 2) : climbStairs1(n - 2));
        return result;
    }
    int[] dpTable2 =new int[]{1,2};
    public int climbStairs2(int n) {
        if (n<3){

            return n;
        }
        int i=3;
        while (i<=n){
            int iResult =dpTable2[0]+dpTable2[1];
            dpTable2[0]=dpTable2[1];
            dpTable2[1]=iResult;
            i++;
        }
        return dpTable2[1];
    }
}
