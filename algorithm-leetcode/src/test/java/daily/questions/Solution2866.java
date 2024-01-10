package daily.questions;

import java.util.*;

/**
 * 美丽塔
 * link{https://leetcode.cn/problems/beautiful-towers-ii/description/}
 * 动态规划 + 单调栈 + 前后缀分解
 */
class Solution2866 {
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        int size = maxHeights.size();
        int[] leftMin = new int[size];
        Arrays.fill(leftMin, -1);
        int[] rightMin = new int[size];
        Arrays.fill(rightMin, size);
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> rightStack = new LinkedList<>();

        // 左边最小的
        leftStack.push(size - 1);
        for (int i = size - 2; i >= 0; i--) {
            while(!leftStack.isEmpty() && maxHeights.get(i) < maxHeights.get(leftStack.peek())){
                Integer pop = leftStack.pop();
                leftMin[pop] = i;
            }
            leftStack.push(i);
        }
        // 右边最小的
        rightStack.push(0);
        for (int i = 1; i < size; i++) {
            while(!rightStack.isEmpty() && maxHeights.get(i) < maxHeights.get(rightStack.peek())){
                Integer pop = rightStack.pop();
                rightMin[pop] = i;
            }
            rightStack.push(i);
        }

        long ans = 0;
        long[] dpL = new long[size];
        long[] dpR = new long[size];
        dpL[0] = (long)maxHeights.get(0);
        dpR[size - 1] = maxHeights.get(size - 1);
        for (int i = 1; i < size; i++) {
            int minIndex = leftMin[i];
            if (minIndex == -1){
                dpL[i] = (long) maxHeights.get(i) * (i + 1);
            }else{
                dpL[i] = (long) maxHeights.get(i) * (i - minIndex) + dpL[minIndex];
            }
        }
        for (int i = size - 2; i >= 0; i--) {
            int minIndex = rightMin[i];
            if (minIndex == size){
                dpR[i] = (long) maxHeights.get(i) * (size - i);
            }else{
                dpR[i] = (long) maxHeights.get(i) * (minIndex - i) + dpR[minIndex];
            }
            ans = Math.max(dpR[i] + dpL[i] - maxHeights.get(i), ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(3);
        test.add(4);
        test.add(1);
        test.add(1);
        maximumSumOfHeights(test);
    }
}