package com.heming.learn.leetcode.sort;

public class BaseSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 6, 8, 3, 4, 9, 2};
        // bubble(nums);
        //selectSort(nums);
        //insertSort(nums);
        //shellSort(nums);
        mergeSort(nums);
        printList(nums);
    }

    private static void printList(int[] nums) {
        System.out.println("---------------");
        for (int num : nums) {
            System.out.print("" + num + " ");
        }
        System.out.println();
        System.out.println("---------------");
    }

    private static void bubble(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }

    }

    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            for (int k = i - 1; k >= 0; k--) {
                if (nums[k] > tmp) {
                    swap(nums, k, k + 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void shellSort(int[] nums) {
        int gap = nums.length >> 1;
        for (; gap > 0; gap = gap >> 1) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < nums.length; j += gap) {
                    int k = j - gap;
                    while (k > 0) {
                        if (nums[k + gap] < nums[k]) {
                            swap(nums, k + gap, k);
                        }
                        k -= gap;
                    }
                }
            }
        }
    }

    private static void mergeSort(int[] nums) {
       int[] sort = merge(nums, 0, nums.length - 1);
       for (int i=0;i<nums.length;i++){
           nums[i]=sort[i];
       }
    }

    private static int[] merge(int[] nums, int start, int end) {
        if (start > end) {
            return new int[]{};
        }
        if (start == end) {
            int[] result = new int[1];
            result[0] = nums[start];
            return result;
        }
        if (end - start == 1) {
            int[] result = new int[2];
            result[0] = Math.min(nums[start], nums[end]);
            result[1] = Math.max(nums[start], nums[end]);
            return result;
        }
        int mid = (start + end + 1) >> 1;
        int[] left = merge(nums, start, mid);
        int[] right = merge(nums, mid + 1, end);
        int[] result = mergeArray(left, right);
        return result;
    }

    private static int[] mergeArray(int[] left, int[] right) {
        if (left == null || left.length == 0) {
            return right;
        }
        if (right == null || right.length == 0) {
            return left;
        }
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;
        int[] result = new int[left.length + right.length];
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }
        while (leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }
        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }
        return result;
    }
//    private static void bubble(int[] nums){
//        for (int i=1;i<nums.length;i++){
//            for (int k=i;k>0;k--){
//                if (nums[k]<nums[k-1]){
//                    swap(nums,k,k-1);
//                }
//
//            }
//        }
//
//    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
