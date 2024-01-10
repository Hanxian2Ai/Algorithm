package com.hanxian.algorithm.leetcode.questions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Solution1457 {

    public final static int recordSize = 9;
    static int res = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] record = new int[recordSize];
        dfs(root, record);
        return res;

    }

    public void dfs(TreeNode root, int[] record) {
        if (root == null) {
            return;
        }
        record[root.val - 1] ^= 1;
        if (root.right == null && root.left == null) {
            if (Arrays.stream(record).sum() <= 1) {
                res++;
            }
        } else {
            dfs(root.left, record);
            dfs(root.right, record);
        }
        record[root.val - 1] ^= 1;
    }

    @Test
    public void main() {
        Integer[] nodes = new Integer[]{2, 1, 1, 1, 3, null, null, null, null, null, 1};
        TreeNode treeNode = new TreeNode();
        TreeNode node = treeNode.treeNode(nodes);
        int i = pseudoPalindromicPaths(node);
        System.out.println(i);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode treeNode(Integer[] nodes) {
            if (nodes == null || nodes.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(nodes[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;

            while (!queue.isEmpty() && i < nodes.length) {
                TreeNode node = queue.poll();

                // 构造左子节点
                if (nodes[i] != null) {
                    TreeNode leftChild = new TreeNode(nodes[i]);
                    node.left = leftChild;
                    queue.add(leftChild);
                }
                i++;

                // 构造右子节点
                if (i < nodes.length && nodes[i] != null) {
                    TreeNode rightChild = new TreeNode(nodes[i]);
                    node.right = rightChild;
                    queue.add(rightChild);
                }
                i++;
            }

            return root;
        }
    }


}