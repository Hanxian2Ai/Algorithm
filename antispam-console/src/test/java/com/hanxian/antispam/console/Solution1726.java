package com.hanxian.antispam.console;

import java.util.Arrays;
import java.util.HashMap;

class Solution1726 {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                hashMap.put(key,hashMap.getOrDefault(key, 0) + 1);
            }
        }

        return hashMap.values().stream().mapToInt(a -> 4 * a * (a - 1)).sum();
    }
}