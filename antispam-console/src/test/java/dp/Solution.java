package dp;

import com.hanxian.antispam.console.AntispamConsoleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AntispamConsoleApplication.class)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i < k; i++) {
            dp[i + 1][0] = -prices[0];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] + prices[i]);
            }

        }
        return dp[k][1];
    }

    @Test
    public void test(){
        maxProfit(2, new int[]{2,1,2,0,1});
    }
}