package com.hanxian.algorithm.leetcode.daily.questions;

import com.hanxian.algorithm.leetcode.common.TreeNode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/
 * 1457. 二叉树中的伪回文路径
 */
class Solution1457Twice {
    private static final int NODE_VALUE_SIZE = 10;

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[NODE_VALUE_SIZE];
        return dfs(root, count);
    }

    private int dfs(TreeNode node, int[] count) {
        if (node == null) {
            return 0;
        }
        count[node.getVal()] ^= 1;
        int res;
        if (node.getLeft() == null && node.getRight() == null) {
            res = Arrays.stream(count).sum() <= 1 ? 1 : 0;
        } else {
            res = dfs(node.getLeft(), count) + dfs(node.getRight(), count);
        }
        count[node.getVal()] ^= 1;
        return res;
    }
}