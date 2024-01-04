package daily.questions;

import java.util.*;

/**
 * 2397. 被列覆盖的最多行数
 * https://leetcode.cn/problems/maximum-rows-covered-by-columns/description/
 * 二进制枚举 Gosper's Hack优化枚举子集
 */
class Solution2397 {
    public static int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] mask = new int[m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1){
                    mask[i] |=  1 << (n - j);
                }
            }
        }
        int res = 0;
        int cur = (1 << numSelect) - 1;
        int limit = (1 << n);
        while (cur < limit) {
            int t = 0;
            for (int j = 0; j < m; j++) {
                if ((mask[j] & cur) == mask[j]) {
                    ++t;
                }
            }
            res = Math.max(res, t);
            int lb = cur & -cur;
            int r = cur + lb;
            cur = ((r ^ cur) >> Integer.numberOfTrailingZeros(lb) + 2) | r;
        }
        return res;
    }

    public void GospersHack(int k, int n){
        int cur = (1 << k) - 1;
        int limit = 1 << n;
        while(cur < limit){
            int lb = cur & -cur;
            // 找最后一个01 变为10。。。。
            int r = cur + lb;
            cur = ((cur ^ r) >> Integer.numberOfTrailingZeros(lb) + 2) | r;
        }
    }

    public static void main(String[] args) {
        maximumRows(new int[][]{{0,0,1},{1,0,0},{0,0,0}},2);
    }
}