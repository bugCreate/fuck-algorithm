package com.heming.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_119 {
    public static void main(String[] args) {
        LeetCode_119 code = new LeetCode_119();
        System.out.println(code.getRow(1));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        int i = 2;
        while (i <= rowIndex + 1) {
            List<Integer> tmp = pre;
            pre = result;
            result = tmp;
            result.clear();
            for (int k = 0; k < i; k++) {
                result.add((k - 1 < 0 ? 0 : pre.get(k - 1)) + (k == pre.size() ? 0 : pre.get(k)));
            }

            i++;
        }
        return result;
    }
}
