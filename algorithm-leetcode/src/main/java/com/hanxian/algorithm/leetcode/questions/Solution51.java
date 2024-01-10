package com.hanxian.algorithm.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        HashSet<Integer> hang = new HashSet<>();
        HashSet<Integer> xie1 = new HashSet<>();
        HashSet<Integer> xie2 = new HashSet<>();
        backTracking(solutions, queens, n, 1, hang, xie1, xie2);
        return solutions;

    }

    private void backTracking(List<List<String>> solutions, int[] queens, int n, int row, HashSet<Integer> hang, HashSet<Integer> xie1, HashSet<Integer> xie2) {
        if (row == n) {
            solutions.add(genRes(queens, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (hang.contains(i)) {
                continue;
            }
            int diff = row - i;
            if (xie1.contains(diff)) {
                continue;
            }
            int sum = row + i;
            if (xie2.contains(sum)) {
                continue;
            }
            queens[row] = i;
            hang.add(i);
            xie1.add(diff);
            xie2.add(sum);
            backTracking(solutions, queens, n, row + 1, hang, xie1, xie2);
            queens[row] = -1;
            hang.remove(i);
            xie1.remove(diff);
            xie2.remove(sum);
        }

    }

    private List<String> genRes(int[] queens, int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[queens[i]] = 'Q';
            list.add(new String(chars));
        }
        return list;
    }
}