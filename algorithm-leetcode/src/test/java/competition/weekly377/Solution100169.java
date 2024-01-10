package competition.weekly377;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * 100169. 移除栅栏得到的正方形田地的最大面积
 * https://leetcode.cn/problems/maximum-square-area-by-removing-fences-from-a-field/description/
 * hashSet 枚举
 */
class Solution100169 {
        private static final int INF = 1_000_000_007;
        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            HashSet<Integer> hSet = calAllDis(hFences, m);
            HashSet<Integer> vSet = calAllDis(vFences, n);
            long res = -1;
            for (int h : hSet) {
                if (vSet.contains(h)) {
                    res = Math.max(res, h);
                }
            }
            return res == -1 ? -1 :(int)(res * res % INF);

        }
        private HashSet<Integer> calAllDis(int[] nums, int max){
            nums = handleNums(nums, max);
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    set.add(Math.abs(nums[j] - nums[i]));
                }
            }
            return set;
        }

        private int[] handleNums(int[] nums, int max){
            int[] newH = new int[nums.length + 2];
            System.arraycopy(nums, 0, newH, 1, nums.length);
            newH[0] = 1;
            newH[nums.length + 1] = max;
            return newH;
        }
        @Test
        public void test(){
            maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2});
        }

}