package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/minimum-time-to-make-array-sum-at-most-x/description/
 * 2809. 使数组和小于等于 x 的最少时间
 * dp 0-1背包
 */
class Solution2809 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size(), s1 = 0, s2 = 0;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i);
            int b = nums2.get(i);
            pairs[i][0] = a;
            pairs[i][1] = b;
            s1 += a;
            s2 += b;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = pairs[i][0];
            int b = pairs[i][1];
            for (int j = i + 1; j > 0; j--) {
                f[j] = Math.max(f[j], f[j - 1] + a + b * j);
            }
        }

        for (int t = 0; t <= n; t++) {
            if (s1 + s2 * t - f[t] <= x) {
                return t;
            }
        }
        return -1;
    }
}

