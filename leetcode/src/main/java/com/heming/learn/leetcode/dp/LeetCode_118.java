package com.heming.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_118 {

    public static void main(String[] args) {
        LeetCode_118 leetCode_118 = new LeetCode_118();
        System.out.println(leetCode_118.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
        List<Integer> list = new ArrayList<Integer>(1);
        list.add(1);
        result.add(list);
        if (numRows<1){
            return Collections.emptyList();
        }
        for (int i=2;i<=numRows;i++){
            List<Integer> tmp = new ArrayList<Integer>(i);
            tmp.add(1);
            tmp.addAll(reduce(result.get(i-2)));
            tmp.add(1);
            result.add(tmp);
        }
        return result;
    }
    public List<Integer> reduce(List<Integer> target){
        if (target.size()<2){
            return Collections.emptyList();
        }
        int i=0,k=1;
        List<Integer> list = new ArrayList<Integer>();
        while (k<target.size()){
            list.add(target.get(i)+target.get(k));
            i++;
            k++;
        }
        return list;
    }
}
