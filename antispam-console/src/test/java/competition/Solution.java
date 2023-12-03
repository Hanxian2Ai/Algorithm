package competition;

import java.util.Arrays;

class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int[] dp = new int[target + 1];
        int res = 0;
        int sum = 1;
        int i = 1;
        if (coins[0] != 1){
            res ++;
            i = 0;
        }
        for (; i < coins.length; i++) {
            while(coins[i] - 1 > sum){
                sum += sum + 1;
                res++;
            }
            sum += coins[i];
        }

        while(sum < target){
            sum += sum + 1;
            res ++;
        }

        return res;
    }
}