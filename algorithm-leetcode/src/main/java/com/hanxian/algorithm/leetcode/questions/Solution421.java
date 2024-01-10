package com.hanxian.algorithm.leetcode.questions;

import java.util.HashSet;
import java.util.Set;

class Solution421 {
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            Set<Integer> seen = new HashSet<Integer>();
            for (int num : nums) {
                seen.add(num >> k);
            }

            int xNext = x * 2 + 1;
            boolean found = false;

            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {

                x = xNext - 1;
            }
        }
        return x;
    }
}
