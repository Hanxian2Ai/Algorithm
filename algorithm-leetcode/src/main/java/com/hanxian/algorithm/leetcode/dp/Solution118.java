package com.hanxian.algorithm.leetcode.dp;

class Solution118 {
    public int maxProfit(int[] prices) {
        int k = 2;
        int length = prices.length;
        int[] dp = new int[2 * k + 1];
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[i] = -prices[0];
            i += 2;
        }


        for (int i = 1; i < length; i++) {
            for (int j = 1; j < 2 * k; j += 2) {
                dp[j] = Math.max(dp[j - 1] - prices[i], dp[j]);
                dp[j + 1] = Math.max(dp[j] + prices[i], dp[j + 1]);

            }
        }
        return dp[2 * k];
    }
}
