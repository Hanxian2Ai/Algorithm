package daily.questions;

/**
 * 466. 统计重复个数
 * https://leetcode.cn/problems/count-the-repetitions/description/
 * 计数法 感觉不像dp 优化的暴力解
 */
class Solution466 {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] dp = new int[s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            int j = i;
            for (int p = 0; p < s1.length(); p++) {
                if (s1.charAt(p) == s2.charAt(j)) {
                    j = (j + 1) % s2.length();
                    dp[i]++;
                }
            }
        }
        int cnt = 0, p = 0;
        for (int i = 0; i < n1; i++) {
            int add = dp[p];
            p = (p + add) % s2.length();
            cnt += add;
        }
        return cnt / s2.length() / n2;
    }

    public static void main(String[] args) {
        getMaxRepetitions("acb", 4, "ab", 2);
    }
}
