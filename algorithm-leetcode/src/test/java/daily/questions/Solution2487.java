package daily.questions;


import java.util.LinkedList;

/**
 * 2487. 从链表中移除节点
 * https://leetcode.cn/problems/remove-nodes-from-linked-list/description/
 * 单调栈 递归
 */
class Solution2487 {
    public static ListNode removeNodes(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode now = head;
        while (now != null) {
            while (!stack.isEmpty() && now.val > stack.peek()) {
                stack.pop();
            }
            stack.push(now.val);
            now = now.next;
        }
        ListNode listNode = null;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            ListNode node = new ListNode(pop);
            node.next = listNode;
            listNode = node;
        }
        return listNode;
    }

    public static void main(String[] args) {
        int[] list = {5, 2, 13, 3, 8};
        ListNode listNode = null;
        for (int i = list.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(list[i]);
            node.next = listNode;
            listNode = node;
        }
        removeNodes(listNode);

    }

    public ListNode removeNodes2(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode node = removeNodes2(head.next);

        if (node.val > head.val) {
            return node;
        }
        head.next = node;
        return head;
    }

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
}
