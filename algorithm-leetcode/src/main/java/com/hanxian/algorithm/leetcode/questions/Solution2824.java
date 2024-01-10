package com.hanxian.algorithm.leetcode.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2824 {
    public static int countPairs(List<Integer> nums, int target) {
        int res = 0;
        Collections.sort(nums);
        for (int i = 0; i < nums.size() - 1; i++) {
            int right = nums.size() - 1;
            while(right > i && nums.get(i) + nums.get(right) >= target){
                right--;
            }
            res += right - i;
        }
        return res;

//        int res = 0;
//        for (int i = 0; i < nums.size() - 1; i++) {
//            for (int j = i + 1; j < nums.size(); j++) {
//                if(nums.get(i) + nums.get(j) < target){
//                    res++;
//                }
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {
        countPairs(new ArrayList<Integer>(List.of(-1,1,2,3,1)),2);
    }
}