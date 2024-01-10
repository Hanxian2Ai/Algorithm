package com.hanxian.algorithm.leetcode.questions;

import java.util.HashMap;

/**
 * 447. 回旋镖的数量
 * https://leetcode.cn/problems/number-of-boomerangs/description/
 * hash表
 */
class Solution447 {
    public static int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] point : points) {
            map.clear();
            for (int[] plot : points) {
                int dis = (plot[0] - point[0]) * (plot[0] - point[0]) + (plot[1] - point[1]) * (plot[1] - point[1]);
                if (map.containsKey(dis)) {
                    res += (map.get(dis) + 1) * 2;
                }
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }

}