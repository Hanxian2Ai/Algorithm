package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.LinkedList;

class Solution907 {
    private static final int MOD = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        int size = arr.length;
        int[] dp = new int[size];
        long res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            int k = stack.isEmpty() ? i + 1 : (i - stack.peek());
            dp[i] = k * arr[i] + (stack.isEmpty() ? 0 : dp[i - k]);
            res = (res + dp[i]) % MOD;
            stack.push(i);
        }
        return (int) res;
    }
}