package com.heming.learn.leetcode.list;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_217 {
    public static void main(String[] args) {
        System.out.println(1^1);
        System.out.println(1|1);
        System.out.println(0^1);
        System.out.println(0|1);
        System.out.println(2^2);
        System.out.println(1&2);
        System.out.println(0&2);
        System.out.println(2&2);
        System.out.println(2|2);
        System.out.println(4^6);

        System.out.println(2&-2);
        // 排序、set
        // 不能使用位运算
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
            set.add(integer);
        }
        return set.size()!= nums.length;
    }
}
