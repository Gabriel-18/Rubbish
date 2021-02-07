package 高频面试题.leetcode;

import leetcode.ListNode;

public class _142环形链表II {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        slow = slow.next;
        fast = fast.next.next;
        // 第一次相遇
        while (slow != fast) {
            // 判断有无环
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // 重置一个
        fast = head;
        // 第二次相遇
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
