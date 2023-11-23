package competition;

import cn.hutool.core.lang.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        List<List<Pair<Integer, Integer>>> toAnswer = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            toAnswer.add(new ArrayList<>());
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (u == v || heights[u] < heights[v]) {
                ans[i] = v;
            } else {
                toAnswer.get(v).add(new Pair<>(i, heights[u]));
            }
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});

        for (int idx = n - 1; idx >= 0; idx--) {
            while (stack.peek()[1] <= heights[idx]) {
                stack.pop();
            }

            for (Pair<Integer,Integer> j : toAnswer.get(idx)) {
                int l = 0, r = stack.size() - 1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if (stack.get(m)[1] > j.getValue()) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                ans[j.getKey()] = stack.get(r)[0];
            }

            stack.push(new int[]{idx, heights[idx]});
        }

        return ans;
    }
}
