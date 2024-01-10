package com.hanxian.algorithm.leetcode.dp;

class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int[] zeroAndOneNums = countZeroAndOneNums(str);
            int zeroNums = zeroAndOneNums[0];
            int oneNums = zeroAndOneNums[1];
            for (int i = m; i >= zeroNums; i--) {
                for (int j = n; j >= oneNums; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNums][j - oneNums] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] countZeroAndOneNums(String str) {
        int[] intArray = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0') {
                intArray[0] += 1;
            } else {
                intArray[1] += 1;
            }
        }
        return intArray;
    }
}