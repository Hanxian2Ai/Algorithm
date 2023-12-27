package daily.questions;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int checkRecord(int n) {
        long[][][] dp = new long[n + 1][2][3];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        dp[1][1][0] = 1;
        for (int i = 2; i < n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][0][1] = dp[i- 1][0][0];
            dp[i][0][2] = dp[i- 1][0][1];
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][1][1] = dp[i -1][1][0];
            dp[i][1][2] = dp[i- 1][1][1];
        }
        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[n - 1][i][j]) % MOD;
            }
        }
        return (int) ans;
    }
}