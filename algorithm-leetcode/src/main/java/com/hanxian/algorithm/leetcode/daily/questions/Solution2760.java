package com.hanxian.algorithm.leetcode.daily.questions;

public class Solution2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0, i = 0;
        while (i < n) {
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                i++; 
                continue;
            }
            int start = i; 
            i++; 
            while (i < n && nums[i] <= threshold && nums[i] % 2 != nums[i - 1] % 2) {
                i++;
            }

            ans = Math.max(ans, i - start);
        }
        return ans;
    }
}

