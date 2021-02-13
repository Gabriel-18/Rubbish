package 高频面试题.牛客;

import leetcode.ListNode;

public class 删除链表的倒数第n个节点 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode l1 = head, l2 = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (l1 != null && n-- >0) {
            l1 = l1.next;
        }

        if (n > 0) {
            return null;
        }
        while (l1 != null && l2 != null) {
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        pre.next = l2.next;

        return dummy.next;

    }
}
