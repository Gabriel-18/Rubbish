package 高频面试题.牛客;

import 剑指offer.ListNode;

public class 合并有序链表 {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
