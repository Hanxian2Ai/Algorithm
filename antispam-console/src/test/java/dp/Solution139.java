package dp;

import java.util.HashSet;
import java.util.List;

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (String s1 : wordDict) {
                int length = s1.length();
                if (i >= length && dp[i - length] && s1.equals(s.substring(i - length, i))) {
                    dp[i] = true;
                }
            }

        }
        return dp[s.length()];
    }
}