package 高频面试题.leetcode;

import leetcode.ListNode;

public class _143重排链表 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 这种操作 找的是右中点
        ListNode mid = slow;
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse (l2);
        mergeList(l1, l2);
    }



    public ListNode reverse(ListNode head) {
        ListNode pre = null , next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode next1;
        ListNode next2;
        while (l1 != null && l2 != null) {
            next1 = l1.next;
            next2 = l2.next;

            l1.next = l2;
            l1 = next1;

            l2.next = l1;
            l2 = next2;
        }
    }

}
