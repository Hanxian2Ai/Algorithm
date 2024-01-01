package daily.questions;

import java.util.ArrayList;

/**
 * 1599. 经营摩天轮的最大利润
 * https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/description/
 * 蠢比模拟题 这辈子不做第二遍
 */
class Solution {
    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int holdPeople = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < customers.length; i++) {
            holdPeople += customers[i];
            if (holdPeople <= 4){
                list.add(holdPeople);
                holdPeople = 0;
            }else{
                holdPeople -=4;
                list.add(4);
            }
        }
        if (holdPeople != 0){
            for (int i = 0; i < holdPeople / 4; i++) {
                list.add(4);
            }
            if (holdPeople % 4 != 0){
                list.add(holdPeople % 4);
            }
        }
        int maxProfit = 0;
        int sum = 0;
        int running = 0;
        int min = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            running++;
            int now = (sum * boardingCost - running * runningCost);
            if (now > maxProfit){
                maxProfit = now;
                min = running;
            }
        }
        if (maxProfit <= 0){
            return  -1;
        }
        return min;
    }

    public static void main(String[] args) {
        minOperationsMaxProfit(new int[]{1,2,1,2,1,2,1,1}, 90, 46);
    }
}