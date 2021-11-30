package com.heming.learn.leetcode.dp;

public class LeetCode_392 {
    public static void main(String[] args) {
        LeetCode_392 leetCode_392 = new LeetCode_392();
        String s = "axc", t = "ahbgdc";
        System.out.println(leetCode_392.isSubsequence(s,t));
    }
    public boolean isSubsequence(String s, String t) {
        int sIndex=0,tIndex=0;
        while (sIndex<s.length()&&tIndex<t.length()) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }
        return sIndex==s.length();
    }
}
