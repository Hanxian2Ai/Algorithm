package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.HashSet;

/**
 * 2670. 找出不同元素数目差数组
 * https://leetcode.cn/problems/find-the-distinct-difference-array/description/
 */
class Solution2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            res[i] += hashSet.size();
        }

        hashSet.clear();
        hashSet.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] -= hashSet.size();
            hashSet.add(nums[i]);
        }
        return res;
    }
}