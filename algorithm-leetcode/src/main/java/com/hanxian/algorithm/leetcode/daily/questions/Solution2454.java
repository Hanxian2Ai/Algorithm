package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution2454 {
    public int[] secondGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> stackTwice = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            while (!stackTwice.isEmpty() && x > nums[stackTwice.peek()]) {
                ans[stackTwice.pop()] = x;
            }
            ArrayList<Integer> tem = new ArrayList<>();
            while (!stack.isEmpty() && x > nums[stack.peek()]) {
                tem.add(stack.pop());
            }
            stack.push(i);

            for (int j = tem.size() - 1; j >= 0; j--) {
                stackTwice.push(tem.get(j));
            }
        }
        return ans;
    }
}