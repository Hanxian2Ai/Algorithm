package com.hanxian.antispam.console;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 10, 10, 10, 10};
        maxKelements(nums, 5);
    }
    public static long maxKelements(int[] nums, int k) {
        long result = 0;
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        for (int i = 0; i < k; i++) {
            int pollNum = pq.poll();
            result += pollNum;
            pq.offer((pollNum+ 2) / 3);
        }
        return result;
    }
}
