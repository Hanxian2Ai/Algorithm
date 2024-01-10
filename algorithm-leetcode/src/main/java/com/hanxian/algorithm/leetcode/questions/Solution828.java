package com.hanxian.algorithm.leetcode.questions;

import java.util.Arrays;

class Solution828 {
    public int uniqueLetterString(String s) {
        char[] cs = s.toCharArray();
        int[] last = new int[26], llast = new int[26]; // 分别存储上上次和上一次出现的位置
        Arrays.fill(last, -1);
        Arrays.fill(llast, -1);
        int n = cs.length, ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            int c = cs[i] - 'A';
            sum += (i - last[c]) - (last[c] - llast[c]);
            ans += sum;
            llast[c] = last[c]; // 更新上上次出现位置
            last[c] = i; // 更新上次出现位置
        }
        return ans;
    }
}
