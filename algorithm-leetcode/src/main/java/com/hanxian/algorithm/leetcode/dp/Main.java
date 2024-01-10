package com.hanxian.algorithm.leetcode.dp;

import java.util.Arrays;

public class Main {
    public static int findSmallerElements(int[] nums) {
        int n = nums.length;
        int[] lMin = new int[n];
        int[] rMin = new int[n];
        Arrays.fill(lMin, Integer.MAX_VALUE);
        Arrays.fill(rMin, Integer.MAX_VALUE);

        for (int i = 1; i < nums.length; i++) {
            lMin[i] = Math.min(nums[i - 1], lMin[i - 1]);
        }

        for (int j = nums.length - 2; j >= 0; j--) {
            rMin[j] = Math.min(rMin[j + 1], nums[j + 1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > lMin[i] && nums[i] > rMin[i]) {
                res = Math.min(res, nums[i] + lMin[i] + rMin[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 3};
        int result = findSmallerElements(arr);
    }
}