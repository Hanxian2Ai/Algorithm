package com.hanxian.algorithm.leetcode.questions;

import java.util.*;

class Solution2003 {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                node = i;
                break;
            }
        }
        if (node < 0) {
            return ans;
        }

        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parents[i]].add(i);
        }

        Set<Integer> vis = new HashSet<>();
        int mex = 2;
        while (node >= 0) {
            dfs(node, g, vis, nums);
            while (vis.contains(mex)) {
                mex++;
            }
            ans[node] = mex;
            node = parents[node];
        }
        return ans;
    }

    private void dfs(int x, List<Integer>[] g, Set<Integer> vis, int[] nums) {
        vis.add(nums[x]);
        for (int son : g[x]) {
            if (!vis.contains(nums[son])) {
                dfs(son, g, vis, nums);
            }
        }
    }
}