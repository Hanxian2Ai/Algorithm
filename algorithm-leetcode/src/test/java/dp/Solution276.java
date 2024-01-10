package dp;

import java.util.Arrays;

class Solution276 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i * i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }

        }
        return dp[n];
    }
}