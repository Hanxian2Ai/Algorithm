package com.hanxian.algorithm.leetcode.questions;

class Solution1954 {
    public long minimumPerimeter(long neededApples) {
        long sum = 12;
        if (neededApples <= 12) {
            return 2 * 4;
        }
        for (int i = 4; ; i += 2) {
            sum += countApples(i / 2);
            if (neededApples <= sum) {
                return i * 4L;
            }
        }
    }

    private long countApples(int n) {
        return ((3L * n - 1) * n + n) * 4;
    }

    public void test() {
        minimumPerimeter(1000000000L);
    }
}