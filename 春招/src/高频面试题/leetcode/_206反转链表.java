package 高频面试题.leetcode;

import leetcode.ListNode;

public class _206反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null, cur = head;
        while (cur != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
