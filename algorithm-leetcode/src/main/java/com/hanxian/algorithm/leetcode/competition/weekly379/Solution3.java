package com.hanxian.algorithm.leetcode.competition.weekly379;

import java.util.HashSet;
import java.util.Set;

/**
 * 100150. 移除后集合的最多元素数
 * https://leetcode.cn/problems/maximum-size-of-a-set-after-removals/description/
 * hashSet 分类讨论 合并两个hashSet
 */
class Solution3 {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int size = nums1.length / 2;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int canRemove1 = 0;
        int canRemove2 = 0;

        for (int i : nums1) {
            if (set1.contains(i)) {
                canRemove1++;
            } else {
                set1.add(i);
            }
        }

        for (int i : nums2) {
            if (set2.contains(i)) {
                canRemove2++;
            } else {
                set2.add(i);
            }
        }
        int countNumber = countTwoMap(set1, set2);
        if (canRemove1 >= size && canRemove2 >= size) {
            return countNumber;
        }
        if (canRemove1 >= size && canRemove2 < size) {
            int res = countNumber;
            int haiQue = size - canRemove2;
            for (int key : set2) {
                if (set1.contains(key)) {
                    haiQue--;
                }
            }
            if (haiQue <= 0) {
                return res;
            } else {
                return res - haiQue;
            }
        }

        if (canRemove2 >= size && canRemove1 < size) {
            int res = countNumber;
            int haiQue = size - canRemove1;
            int reaptNum = set1.size() + set2.size() - countNumber;
            if(reaptNum >= haiQue){
                return res;
            }else{
                return res - haiQue + reaptNum;
            }
        }

        if (canRemove2 < size && canRemove1 < size) {
            int need1 = size - canRemove1;
            int need2 = size - canRemove2;
            int reaptNum = set1.size() + set2.size() - countNumber;
            int dis = need1 + need2 - reaptNum;
            return dis < 0 ? countNumber : countNumber - dis;
        }
        return 0;
    }

    public int countTwoMap(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> keySet = new HashSet<>(set1);
        keySet.addAll(set2);
        return keySet.size();
    }
}