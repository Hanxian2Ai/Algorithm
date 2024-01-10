package com.hanxian.algorithm.leetcode.questions;


import java.util.ArrayList;

class Solution2477 {

    private long ans;

    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= roads.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        dfs(0, -1, tree, seats);
        return ans;
    }

    private int dfs(int x, int fa, ArrayList<ArrayList<Integer>> tree, int seats) {
        int size = 1;
        for (int y : tree.get(x)) {
            if (y != fa) {
                size += dfs(y, x, tree, seats);
            }
        }
        if (x > 0) {
            ans += (size + seats - 1) / seats;
        }
        return size;
    }

    public void test() {
        int[][] arr = {{0, 1}, {0, 2}, {0, 3}};
        minimumFuelCost(arr, 5);
    }
}