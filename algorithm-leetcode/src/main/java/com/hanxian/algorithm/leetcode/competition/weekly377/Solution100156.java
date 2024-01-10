package com.hanxian.algorithm.leetcode.competition.weekly377;

/**
 * 100156. 转换字符串的最小成本 I
 * https://leetcode.cn/problems/minimum-cost-to-convert-string-i/description/
 * floyd 多源最短路径
 */
class Solution100156 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] graph = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < original.length; i++) {
            graph[original[i]-'a'][changed[i]- 'a'] = Math.min(cost[i], graph[original[i]-'a'][changed[i]- 'a']);
        }
        long[][] ints = floydWarshall(graph);
        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)){
                long l = ints[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (l >= Integer.MAX_VALUE){
                    return -1;
                }else{
                    res += l;
                }

            }
        }
        return res;
    }

    public static long[][] floydWarshall(long[][] graph) {
        int n = graph.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {     
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);

                }
            }
        }
        return graph;
    }
}

