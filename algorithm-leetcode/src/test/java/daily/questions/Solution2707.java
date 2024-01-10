package daily.questions;

import java.util.Collections;
import java.util.HashSet;

/**
 * 2707. 字符串中的额外字符
 * https://leetcode.cn/problems/extra-characters-in-a-string/
 * 字符串dp 动态规划
 */
class Solution2707 {
    public int minExtraChar(String s, String[] dictionary) {
        int length = s.length();
        int[] dp = new int[s.length()];
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, dictionary);
        String zeroStr = s.substring(0, 1);
        dp[0] = set.contains(zeroStr) ? 0 : 1;
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j <= i ; j++) {
                if (set.contains(s.substring(j , i + 1))){
                    if (j == 0){
                        dp[i] = 0;
                    }else{
                        dp[i] = Math.min(dp[i], dp[j - 1]);
                    }
                }
            }
        }
        return dp[length - 1];
    }
}