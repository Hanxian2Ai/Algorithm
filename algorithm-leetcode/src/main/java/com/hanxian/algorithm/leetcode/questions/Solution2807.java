package com.hanxian.algorithm.leetcode.questions;

/**
 * 2807. 在链表中插入最大公约数
 * https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/description/?envType=daily-question&envId=2024-01-06
 * 最大公约数 辗转相除法 递归
 */
class Solution2807 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode last = head;
        ListNode now = head.next;
        while (now != null) {
            int lastVal = last.val;
            int nowVal = now.val;
            int insertVal = 0;
            if (lastVal > nowVal) {
                insertVal = gcd(lastVal, nowVal);
            } else {
                insertVal = gcd(nowVal, lastVal);
            }
            ListNode insertNode = new ListNode(insertVal, now);
            last.next = insertNode;
            last = now;
            now = now.next;
        }
        return head;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int c = a % b;
        return gcd(b, c);
    }

    public static void main(String[] args) {
        int[] nums = {18, 6, 10, 3};
        ListNode next = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode listNode = new ListNode(nums[i], next);
            next = listNode;
        }
        insertGreatestCommonDivisors(next);
        System.out.println("hhh");
    }
}