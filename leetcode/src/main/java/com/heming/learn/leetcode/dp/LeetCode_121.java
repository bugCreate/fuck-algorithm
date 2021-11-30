package com.heming.learn.leetcode.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LeetCode_121 {
    public static void main(String[] args) {
        LeetCode_121 leetCode_121 = new LeetCode_121();
        int[] p = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(leetCode_121.maxProfit(p));
    }

    public int maxProfit(int[] prices) {
        int[] backup = new int[prices.length];

        int backUpIndex = 0;
        for (int price : prices) {
            if (price > backup[backUpIndex]) {
                int tmp = backUpIndex;
                while (tmp > 0) {
                    if (price > backup[tmp]) {
                        backup[tmp] = price;
                        tmp--;
                    } else {
                        break;
                    }
                }
            }
            backUpIndex++;
        }


        backUpIndex = 0;
        int detla = 0;
        for (int price : prices) {
            detla = Math.max(detla, backup[backUpIndex] - price);
            System.out.println(price + " " + backup[backUpIndex]);

            backUpIndex++;

        }
        return detla;
    }

}
