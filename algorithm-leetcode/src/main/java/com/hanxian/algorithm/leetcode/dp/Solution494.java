package com.hanxian.algorithm.leetcode.dp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class Solution494 {
    @Test
    public void test() {
        int targetSumWays = findTargetSumWays(new int[]{10}, -10);
        System.out.println(targetSumWays);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        target = Math.max(0, -target);
        if ((target + sum) % 2 != 0) return 0;
        if (target > sum) return 0;

        int bagSize = (target + sum) / 2;


        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}