package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subStr = s.substring(i, i + 10);
            if (set.contains(subStr)) {
                res.add(subStr);
            }
            set.add(subStr);
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}