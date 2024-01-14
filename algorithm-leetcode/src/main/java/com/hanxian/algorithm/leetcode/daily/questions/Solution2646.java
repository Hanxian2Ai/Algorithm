package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.ArrayList;

class Solution2646 {
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] road : edges) {
            int x = road[0];
            int y = road[1];
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        int[] cnt = new int[n];
        for (int[] trip : trips) {
            dfs(trip[0], trip[1], -1, tree, cnt);
        }

        int[] res = dp(0, -1, price, tree, cnt);
        return Math.min(res[0], res[1]);
    }

    private boolean dfs(int x, int end, int father, ArrayList<ArrayList<Integer>> tree, int[] cnt) {
        if (x == end) {
            cnt[x]++;
            return true;
        }
        for (int node : tree.get(x)) {
            if (node != father) {
                if (dfs(node, end, x, tree, cnt)) {
                    cnt[x]++;
                    return true;
                }
            }
        }
        return false;
    }

    private int[] dp(int node, int father, int[] price, ArrayList<ArrayList<Integer>> tree, int[] cnt) {
        int notHalf = price[node] * cnt[node];
        int half = notHalf / 2;
        for (int child : tree.get(node)) {
            if (child != father) {
                int[] res = dp(child, node, price, tree, cnt);
                notHalf += Math.min(res[0], res[1]);
                half += res[0];
            }
        }
        return new int[]{notHalf, half};
    }

    public void test() {

    }
}