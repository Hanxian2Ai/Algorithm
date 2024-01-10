package dp;

public class Solution121 {
    public int maxProfit(int prices[]) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];

    }

    public int maxProfitTanxin(int prices[]) {
        //贪心
        int low = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            low = Math.min(low, price);
            res = Math.max(res, price - low);
        }
        return res;
    }
}