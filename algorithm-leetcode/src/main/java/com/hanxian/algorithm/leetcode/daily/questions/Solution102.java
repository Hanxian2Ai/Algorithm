package com.hanxian.algorithm.leetcode.daily.questions;

import com.hanxian.algorithm.leetcode.daily.questions.Solution1457.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 * 102. 二叉树的层序遍历
 */
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> resLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                resLevel.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(resLevel);
        }

        for (int i = 0; i < res.size(); i++) {
            if (((i + 1) & 1) == 0) {
                List<Integer> item = res.get(i);
                Collections.reverse(item);
                res.set(i, item);
            }
        }
        return res;
    }
}