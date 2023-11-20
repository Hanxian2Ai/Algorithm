package competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                continue;
            }
            if (i > 0 &&nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right --;
                }else if(sum < 0){
                    left++;
                }else{
                    int[] resItem = {nums[i], nums[left], nums[right]};
                    res.add(Arrays.stream(resItem).boxed().collect(Collectors.toList()));
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right -1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}