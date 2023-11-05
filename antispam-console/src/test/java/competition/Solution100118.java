package competition;

import java.util.*;

class Solution100118 {

    List<List<Integer>> grap;
    int[] valueNums;

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {

        initProperties(edges, values);

        long sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum - dfs(0,-1);
    }

    public void initProperties(int[][] edges, int[] values){
        valueNums = values;
        grap = new ArrayList<>(values.length);
        for (int i = 0; i < values.length; i++) {
            grap.add(new ArrayList<>());
        }
        grap.get(0).add(-1);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            grap.get(x).add(y);
            grap.get(y).add(x);
        }
    }

    // dfs(x) 计算以 x 为根的子树是健康时，失去的最小分数
    public long dfs(int x, int fatherNode) {
        List<Integer> nearNodes = grap.get(x);
        if(nearNodes.size() == 1){
            return valueNums[x];
        }
        long loss = 0;
        for (Integer node : nearNodes) {
            if (node != fatherNode){
                loss += dfs(node, x);
            }
        }
        return Math.min(loss, valueNums[x]);
    }

    public static void main(String[] args) {
        Solution100118 solution = new Solution100118();
        int[][] edge = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] values = {20, 10, 9, 7, 4, 3, 5};
        long l = solution.maximumScoreAfterOperations(edge, values);
        System.out.println(l);
    }

}
