package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.Arrays;

/**
 * 2171. 拿出最少数目的魔法豆
 * https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/
 * 排序 + 枚举
 */
public class Solution2171 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0, mx = 0;
        int n = beans.length;
        for (int i = 0; i < n; i++) {
            sum += beans[i];
            mx = Math.max(mx, (long) (n - i) * beans[i]);
        }
        return sum - mx;
    }
}
