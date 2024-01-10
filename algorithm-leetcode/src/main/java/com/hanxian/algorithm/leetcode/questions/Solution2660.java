package com.hanxian.algorithm.leetcode.questions;

class Solution2660 {
    public int i2Winner(int[] player1, int[] player2) {
        int a = countScores(player1);
        int b = countScores(player2);

        if(a == b){
            return 0;
        }

        return a > b ? 1 : 2;

    }

    private int countScores(int[] nums){
        int sum = 0;
        int needDouble = -1;
        for(int i = 0; i < nums.length; i++){
            if(needDouble >= i){
                sum += 2* nums[i];
            }else{
                sum += nums[i];
            }

            if(nums[i] == 10){
                needDouble = i + 2;
            }

        }
        return sum;
    }
}