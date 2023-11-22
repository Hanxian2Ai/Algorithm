package daily.questions;

import java.util.Arrays;

class Solution2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }


        for (int i = 1; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min(grid[i][j] + dp[i -1][k] + moveCost[grid[i - 1][k]][j], dp[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(dp[m - 1][i], res);
        }
        return res;
    }


}