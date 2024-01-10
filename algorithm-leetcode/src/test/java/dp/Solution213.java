package dp;

class Solution213 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robSub(nums, 0, length - 2), robSub(nums, 1, length - 1));
    }

    public int robSub(int[] nums, int start, int end) {
        int length = end - start + 1;
        int dp[] = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i - 1]);
        }
        return dp[length];
    }

}