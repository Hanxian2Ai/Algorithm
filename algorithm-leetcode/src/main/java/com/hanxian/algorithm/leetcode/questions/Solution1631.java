package com.hanxian.algorithm.leetcode.questions;

import com.hanxian.antispam.console.AntispamConsoleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.Queue;


@SpringBootTest(classes = AntispamConsoleApplication.class)
class Solution1631 {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 广度优先遍历
    public int minimumEffortPathBFS(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 999999, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{0, 0});
            boolean[][] seen = new boolean[m][n];
            seen[0][0] = true;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx][ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                        queue.offer(new int[]{nx, ny});
                        seen[nx][ny] = true;
                    }
                }
            }
            if (seen[m - 1][n - 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 深度优先遍历
    public int minimumEffortPathDFS(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 999999, ans = 0;

        while (left <= right) {
            boolean[][] seen = new boolean[m][n];
            seen[0][0] = true;
            int mid = (left + right) >> 1;
            if (dfs(0, 0, mid, heights, seen)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean dfs(int x, int y, int max, int[][] h, boolean[][] s) {
        if (x == h.length - 1 && y == h[0].length - 1) {
            return true;
        }
        s[x][y] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < h.length && ny < h[0].length && ny >= 0 && !s[nx][ny] && Math.abs(h[x][y] - h[nx][ny]) <= max) {
                if (dfs(nx, ny, max, h, s)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] x = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        minimumEffortPathDFS(x);
    }
}