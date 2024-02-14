package com.hanxian.algorithm.leetcode.daily.questions;

import com.hanxian.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HanXian
 */
public class SolutionInOrderPreOrderPostOrder {
    public List<Integer> preOrder(TreeNode node){
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            res.add(treeNode.getVal());
            if (treeNode.getRight() != null){
                stack.push(treeNode.getRight());
            }
            if (treeNode.getLeft() != null){
                stack.push(treeNode.getLeft());
            }
        }
        return res;
    }

    public List<Integer> postOrder(TreeNode node){
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            res.add(treeNode.getVal());
            if (treeNode.getLeft() != null){
                stack.push(treeNode.getLeft());
            }
            if (treeNode.getRight() != null){
                stack.push(treeNode.getRight());
            }
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> inOder(TreeNode node){
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || node != null){
            if (node != null){
                stack.add(node);
                node = node.getLeft();
            }else{
                TreeNode temp = stack.pop();
                res.add(temp.getVal());
                node = temp.getRight();
            }
        }
        return res;
    }

    public void preOrderMorris(TreeNode root) {
        if (root == null) {
            return;
        }
        //当前结点
        TreeNode curr = root;
        //当前节点左子树
        TreeNode currLeft;
        while (curr != null) {
            currLeft = curr.getLeft();
            // 当前结点的左子树存在即可建立连接
            if (currLeft != null) {
                // 找到当前左子树的最右侧节点，并且不能沿着连接返回上层
                while (currLeft.getRight() != null && currLeft.getRight() != curr) {
                    currLeft = currLeft.getRight();
                }
                // 最右侧节点的右指针没有指向根结点，创建连接并往下一个左子树的根结点进行连接操作
                if (currLeft.getRight() == null) {
                    currLeft.setRight(curr);
                    curr = curr.getLeft();
                    continue;  // 这个continue很关键
                } else
                    // 当左子树的最右侧节点有指向根结点，此时说明我们已经进入到了返回上层的阶段，不再是一开始的建立连接阶段，同时在回到根结点时我们应已处理完下层节点，直接断开连接即可。
                {
                    currLeft.setRight(null);
                }
            }
            // 返回上层的阶段不断向右走
            curr = curr.getRight();
        }
    }

    public List<Integer> preorderMorris(TreeNode root) {
        TreeNode curr = root;
        ArrayList<Integer> res = new ArrayList<>();
        while (curr != null) {
            if (curr.getLeft() == null) {
                // 访问当前节点
                res.add(curr.getVal());
                // 向右子树移动
                curr = curr.getRight();
            } else {
                // 在当前节点的左子树中找到前驱节点
                TreeNode predecessor = curr.getLeft();
                while (predecessor.getRight() != null && predecessor.getRight() != curr) {
                    predecessor = predecessor.getRight();
                }
                if (predecessor.getRight() == null) {
                    // 访问当前节点
                    res.add(curr.getVal());
                    predecessor.setRight(curr);
                    // 向左子树移动
                    curr = curr.getLeft();
                } else {
                    predecessor.setRight(null);
                    // 向右子树移动
                    curr = curr.getRight();
                }
            }
        }
        return res;
    }
}
