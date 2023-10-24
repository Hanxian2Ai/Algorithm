package dp;

class Solution1155 {
    int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int m, int t) {
        int[][] f = new int[n + 1][t + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= t; j++) {
                for (int k = 1; k <= m && k < j; k++) {
                    f[i][j] = f[i][j] + f[i][j-k];
                }

            }
        }
        return f[n][t];
    }
}
