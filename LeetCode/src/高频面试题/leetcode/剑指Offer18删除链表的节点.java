package 高频面试题.leetcode;

import leetcode.ListNode;

public class 剑指Offer18删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
