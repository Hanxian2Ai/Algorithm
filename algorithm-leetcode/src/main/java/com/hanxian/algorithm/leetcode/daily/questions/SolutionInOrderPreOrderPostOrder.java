package com.hanxian.algorithm.leetcode.daily.questions;

import com.hanxian.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
}
