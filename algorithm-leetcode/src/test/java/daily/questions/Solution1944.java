package daily.questions;

import java.util.LinkedList;

/**
 * 1944. 队列中可以看到的人数
 * https://leetcode.cn/problems/number-of-visible-people-in-a-queue/description/
 * 单调栈
 */
class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int size = heights.length;
        int[] res = new int[size];
        res[size - 1] = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(heights[size - 1]);

        for (int i = size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(heights[i]);
        }
        return res;
    }
}