package com.hanxian.algorithm.leetcode.dp;

class Solution70 {
    public int climbStairs(int n) {
        int m = 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - j - 1 >= 0) {
                    dp[i] += dp[i - j - 1];
                }
            }
        }
        return dp[n];
    }
}