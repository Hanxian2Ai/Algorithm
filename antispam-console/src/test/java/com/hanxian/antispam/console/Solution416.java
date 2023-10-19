package com.hanxian.antispam.console;

import java.util.Arrays;

class Solution416 {

    public static void main(String[] args) {
        int[] a = {1, 5, 11, 5};
        canPartition(a);
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= target; i++) {
            dp[0][i] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
                if (dp[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}