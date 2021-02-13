package 高频面试题.leetcode;

import leetcode.ListNode;

public class 剑指Offer22链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head, p2 = head;
        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }
        if (k > 0) {
            return null;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
