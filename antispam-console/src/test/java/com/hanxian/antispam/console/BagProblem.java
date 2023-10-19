package com.hanxian.antispam.console;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {6,24,30};
        int bagSize = 4;

        testWeightBagProblem2(weight,value,bagSize);
    }

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int size = weight.length;
        int[][] dp = new int[size][bagSize + 1];

        for (int i = 0; i < size; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < bagSize + 1; i++) {
            dp[0][i] = value[0];
        }

        for(int i = 1; i < size; i++){
            for (int j = 1; j < bagSize + 1; j++) {
                if (j < weight[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     * 一维背包
     */
    public static void testWeightBagProblem2(int[] weight, int[] value, int bagSize){
        int size = weight.length;
        int[] dp = new int[bagSize + 1];
        dp[0] = 0;
        for (int i = 1; i < bagSize + 1; i++) {
            dp[i] = value[0];
        }
        for (int i = 0; i < size; i++) {
            for(int j = bagSize; j >= weight[i]; j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j],dp[j - weight[i]] + value[i]);
            }
        }

        for (int j : dp) {
            System.out.print(j + "\t");
        }

    }

}
