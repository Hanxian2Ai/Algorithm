import java.util.HashMap;

public class MinGroups {
    public static int minGroups(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // 统计每个元素的出现次数
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int numMaxCount = 0;

        // 找到出现次数最多的元素和对应的次数
        for (int num : countMap.keySet()) {
            int count = countMap.get(num);
            if (count > maxCount) {
                maxCount = count;
                numMaxCount = 1;
            } else if (count == maxCount) {
                numMaxCount++;
            }
        }

        // 返回最少组数
        return Math.max(maxCount, numMaxCount);
    }

    public static void main(String[] args) {
        int[] nums = {10,10,10,3,1,1};
        System.out.println(minGroups(nums)); // 输出：3
    }
}