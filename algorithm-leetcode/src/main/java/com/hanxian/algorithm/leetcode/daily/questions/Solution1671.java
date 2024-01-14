package com.hanxian.algorithm.leetcode.daily.questions;


import java.util.Arrays;

/**
 * 1671. 得到山形数组的最少删除次数
 * 前后缀分解 + 最长子序列 nlogn
 * https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/description/
 */
class Solution1671 {
    private static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }

    public int minimumMountainRemovals(int[] nums) {
        int size = nums.length;
        int max = 0;
        for (int i = 1; i < size - 1; i++) {
            int frontMax = lengthOfLIS(nums, 0, i + 1, false);
            int afterMax = lengthOfLIS(nums, i, size, true);
            if (frontMax == 1 || afterMax == 1) {
                continue;
            }
            max = Math.max(max, frontMax + afterMax);

        }
        return size - max + 1;
    }

    public int lengthOfLIS(int[] originNums, int start, int end, boolean isReverse) {
        int[] nums = Arrays.copyOfRange(originNums, start, end);
        if (nums.length == 0) {
            return 0;
        }
        if (isReverse) {
            reverseArray(nums);
        }
        int n = nums.length;
        int length = 1;
        int[] d = new int[n + 1];
        d[length] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[length]) {
                d[++length] = nums[i];
            } else {
                int l = 1, r = length, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return d[length];
    }

    public void test() {
        minimumMountainRemovals(new int[]{9, 8, 1, 7, 6, 5, 4, 3, 2, 1});
    }
}