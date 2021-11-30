package com.heming.learn.leetcode.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] big=nums1.length>nums2.length?nums1:nums2;
        int[] small=nums1.length>nums2.length?nums2:nums1;
        Arrays.sort(big);
        Arrays.sort(small);
        List<Integer> result = new ArrayList<>();
        int bigIndex=0,smallIndex=0;
        for (;bigIndex<big.length;bigIndex++) {
            if (smallIndex>=small.length){
                break;
            }

            while (small[smallIndex]<big[bigIndex]){
                smallIndex++;
                if (smallIndex>=small.length){
                    break;
                }
            }
            if (smallIndex>=small.length){
                break;
            }
            if (small[smallIndex]==big[bigIndex]){
                result.add(small[smallIndex]);
                smallIndex++;
            }

        }
        int[] array = new int[result.size()];
        for (int k=0;k<result.size();k++) {
            array[k]=result.get(k);
        }
        return array;
    }
}
