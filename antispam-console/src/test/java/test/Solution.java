package test;

import java.util.HashMap;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        HashMap
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = LowerBound(sums,i,n,target);

            if (bound !=-1) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public int LowerBound(int[] a, int left, int right, int target){
        int  mid = -1;
        while(left <= right){
            mid = left + ((right -left) >> 1);
            if(a[mid] < target){
                left = mid + 1;
            }else if(a[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }

        return left > right ? -1 : left;
    }
}


