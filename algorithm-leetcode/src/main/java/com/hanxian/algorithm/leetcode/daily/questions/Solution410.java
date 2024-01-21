package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 * https://leetcode.cn/problems/split-array-largest-sum/description/
 * 动态规划、二分查找
 */
public class Solution410 {

    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int[][] dp = new int[len][m + 1];

        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < len; i++) {
            dp[i][1] = preSum[i + 1];
        }

        for (int k = 2; k <= m; k++) {
            for (int i = k - 1; i < len; i++) {
                for (int j = k - 2; j < i; j++) {
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k - 1], preSum[i + 1] - preSum[j + 1]));
                }
            }
        }
        return dp[len - 1][m];
    }
}
