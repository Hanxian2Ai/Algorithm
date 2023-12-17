package competition;

import java.util.Arrays;

class Solution100123 {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int res = 1;
        long[] s = new long[nums.length + 1];

        for(int i = 0; i < nums.length; i++){
            s[i + 1] = nums[i] + s[i];
        }
        int right = 0;
        for (int left = 0; left < nums.length; left++) {
            while(right <= nums.length - 1 && countMinK(nums, s, left, right) <= k){
                right++;
            }
            res = Math.max(res, right - left );
        }
        return res;
    }

    private long countMinK(int[] nums , long[] s ,int left, int right){
        int mid = (left + right) / 2;
        long frontSec = nums[mid] * (mid - left) - (s[mid + 1] - s[left]);
        long backSec = s[right + 1] - s[mid] - nums[mid] * (right - mid);
        return frontSec + backSec;
    }
}