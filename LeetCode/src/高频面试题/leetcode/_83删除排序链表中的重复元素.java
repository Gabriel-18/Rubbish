package 高频面试题.leetcode;

import leetcode.ListNode;

public class _83删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // 删除
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                // 更新
                cur = cur.next;
            }
        }
        return head;
    }
}
