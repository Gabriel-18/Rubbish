package 高频面试题.牛客;

import leetcode.ListNode;

public class 链表中环的入口节点 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode l1 = head, l2 = head;
        // 为什么要这么写呢
        l1 = l1.next;
        l2 = l2.next.next;
        while (l1 != l2) {
            if (l2 == null || l2.next == null) {
                return null;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }

        l2 = head;
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }
}
