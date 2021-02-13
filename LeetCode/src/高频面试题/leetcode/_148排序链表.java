package 高频面试题.leetcode;

import leetcode.ListNode;

public class _148排序链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /* 知识点1：归并排序的整体思想
     * 知识点2：找到一个链表的中间节点的方法
     * 知识点3：合并两个已排好序的链表为一个新的有序链表
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head; //慢指针
        ListNode fast = head.next; //快指针

        while (fast != null && fast.next != null) { //快慢指针找到链表中点
            slow = slow.next; //慢指针走一步
            fast = fast.next.next; //快指针走两步
        }
        ListNode rightHead = slow.next; //链表第二部分的头节点
        slow.next = null; //cut 链表



        ListNode left = sortList(head); //递归排序前一段链表
        ListNode right = sortList(rightHead); //递归排序后一段链表
        return merge(left, right);
    }

    public ListNode merge(ListNode h1, ListNode h2) { //合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if (h1 != null){
            p.next = h1;
        } else if (h2 != null){
            p.next = h2;
        }
        return dummy.next;

    }
}
