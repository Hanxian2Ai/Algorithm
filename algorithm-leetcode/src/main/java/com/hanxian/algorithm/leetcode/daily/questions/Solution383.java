package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.HashMap;

/**
 * 383. 赎金信
 * https://leetcode.cn/problems/ransom-note/description/?envType=daily-question&envId=2024-01-07
 * hashMap或者数组 O(1)取元素
 */
class Solution383 {
    public boolean canConstruct(String ransom, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransom.length(); i++) {
            char c = ransom.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            int cut = map.get(c);
            if (cut == 1) {
                map.remove(c);
            } else {
                map.put(c, cut - 1);
            }
        }
        return true;
    }
}