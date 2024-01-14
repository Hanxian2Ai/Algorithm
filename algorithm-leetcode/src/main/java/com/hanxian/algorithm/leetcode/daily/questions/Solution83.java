package com.hanxian.algorithm.leetcode.daily.questions;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 * 简单链表删除重复 注意最后return
 */
class Solution83 {

    public class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode last = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == last.val){
                last.next = cur.next;
                cur = cur.next;
            }else{
                last = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}