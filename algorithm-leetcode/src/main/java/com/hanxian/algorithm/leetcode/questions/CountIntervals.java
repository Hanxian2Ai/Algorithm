package com.hanxian.algorithm.leetcode.questions;

import java.util.TreeMap;

class CountIntervals {
    int sum = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public CountIntervals() {

    }

    public void add(int left, int right) {
        Integer L = map.floorKey(right);
        while(L!= null && map.get(L) >= left){
            left = Math.min(left, L);
            right = Math.max(right, map.get(L));
            sum -= map.get(L) - L + 1;
            map.remove(L);
            L = map.floorKey(right);
        }
        map.put(left, right);
        sum += right - left + 1;
    }

    public int count() {
        return sum;
    }
}