package com.hanxian.algorithm.leetcode.questions;

import java.util.HashMap;

/**
 * 2085. 统计出现过一次的公共字符串
 * https://leetcode.cn/problems/count-common-words-with-one-occurrence/
 * HashMap
 */
class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (String s : map1.keySet()) {
            if (map1.get(s) == 1 && map2.getOrDefault(s, 0) == 1) {
                res++;
            }
        }
        return res;
    }
}