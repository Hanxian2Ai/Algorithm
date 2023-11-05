package competition;

import java.util.Arrays;

class Solution2719 {
    private static final int MOD = (int) 1e9 + 7;
    private int minSum, maxSum;

    public int count(String num1, String num2, int minSum, int maxSum) {
        this.minSum = minSum;
        this.maxSum = maxSum;
        int ans = count(num2) - count(num1) + MOD;
        int sum = 0;
        for (char c : num1.toCharArray()) sum += c - '0';
        if (minSum <= sum && sum <= maxSum) ans++;
        return ans % MOD;
    }

    private  int count(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] memo = new int[n][Math.min(9 * n, maxSum) + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        return f(s, memo, 0, 0, true);
    }

    private int f(char[] s, int[][] memo, int i, int sum, boolean isLimit) {
        if (sum > maxSum) return 0;
        if (i == s.length) return sum >= minSum ? 1 : 0;
        if (!isLimit && memo[i][sum] != -1) return memo[i][sum];
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; ++d)
            res = (res + f(s, memo, i + 1, sum + d, isLimit && d == up)) % MOD;
        if (!isLimit) memo[i][sum] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution2719 solution2719 = new Solution2719();
        int count = solution2719.count("1", "12", 1, 8);
        System.out.println(count);
    }
}