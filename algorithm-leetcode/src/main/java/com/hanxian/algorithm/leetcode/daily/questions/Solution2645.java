package com.hanxian.algorithm.leetcode.daily.questions;

/**
 * 2645. 构造有效字符串的最少插入数
 *  https://leetcode.cn/problems/minimum-additions-to-make-valid-string/description/
 * 方法一：考虑相邻字母
 */
class Solution2645 {
    public int addMinimum(String word) {
        char[] s = word.toCharArray();
        int ans = s[0] + 2 - s[s.length - 1];
        for (int i = 1; i < s.length; i++) {
            ans += (s[i] + 2 - s[i - 1]) % 3;
        }
        return ans;
    }
}

