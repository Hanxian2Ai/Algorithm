package daily.questions;

class Solution2316 {
    public long countPairs(int n, int[][] edges) {
        int[][] res = new int[n][n];
        for (int[] edge : edges) {
            res[edge[0]][edge[1]] = 1;
            res[edge[1]][edge[0]] = 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && res[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans / 2;
    }
}