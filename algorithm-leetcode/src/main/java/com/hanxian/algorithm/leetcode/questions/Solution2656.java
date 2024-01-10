package com.hanxian.algorithm.leetcode.questions;

class Solution2656 {
    public int maximizeSum(int[] nums, int k) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return k * (max + max + k - 1) / 2;

    }
}