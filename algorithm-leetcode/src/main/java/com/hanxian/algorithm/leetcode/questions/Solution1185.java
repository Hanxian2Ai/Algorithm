package com.hanxian.algorithm.leetcode.questions;

/**
 * 1185. 一周中的第几天
 * https://leetcode.cn/problems/day-of-the-week/description/
 * 枚举模拟 闰年（400倍数 或者 4的倍数且不是100倍数）
 */
class Solution1185 {

    static String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        int days = 4;
        for (int i = 1971; i < year; i++) {
            days += (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) ? 366 : 365;
        }

        for (int i = 1; i < month; i++) {
            boolean isLeak = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
            if (i == 2) {
                days += isLeak ? 29 : 28;
            } else {
                days += nums[i - 1];
            }
        }

        days += day;
        return week[days % 7];
    }
}