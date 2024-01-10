package daily.questions;

class Solution2216 {
    public int minDeletion(int[] nums) {
        int first = nums[0];
        int count = 0;
        int size = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && nums[i] != nums[i + 1]) {
                count += 2;
                i++;
            } else if (nums[i] != nums[i + 1]) {
                count += 2;
                i++;
            }
        }
        return size - count;
    }
}