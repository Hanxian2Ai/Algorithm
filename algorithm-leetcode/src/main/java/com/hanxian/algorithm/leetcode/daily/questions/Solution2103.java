package com.hanxian.algorithm.leetcode.daily.questions;

class Solution2103 {
    public int countPoints(String rings) {
        int n = rings.length();
        int[] states = new int[10];
        int res = 0;
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int index = rings.charAt(i + 1) - '0';
            if (color == 'R') {
                states[index] |= 1;
            } else if (color == 'G') {
                states[index] |= 2;
            } else {
                states[index] |= 4;
            }
        }

        for (int state : states) {
            if (state == 7) {
                res++;
            }
        }
        return res;
    }
}