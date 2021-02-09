package 高频面试题.leetcode;

import leetcode.ListNode;

public class _92反转链表II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        for (int i = 1; i < m; i++) {
            cur = cur.next;
            pre = pre.next;
        }

        // 头插法
        //思路：head表示需要反转的头节点，pre表示需要反转头节点的前驱节点
        //我们需要反转n-m次，我们将head的next节点移动到需要反转链表部分的首部，需要反转链表部分剩余节点依旧保持相对顺序即可
        //比如1->2->3->4->5,m=1,n=5
        //第一次反转：1(head) 2(next) 3 4 5 反转为 2 1 3 4 5
        //第二次反转：2 1(head) 3(next) 4 5 反转为 3 2 1 4 5
        //第三次发转：3 2 1(head) 4(next) 5 反转为 4 3 2 1 5
        //第四次反转：4 3 2 1(head) 5(next) 反转为 5 4 3 2 1
        for (int i = 0; i < n - m; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 反转节点的前一个节点
        ListNode head1 = dummy;
        ListNode cur = dummy.next;

        for (int i = 1; i < m; i++) {
            cur = cur.next;
            head1 = head1.next;
        }
        // 当前反转节点
        // 反转后就是尾节点
        ListNode head2 = cur;
        ListNode pre = null;
        for (int i = 0; i <= n - m; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 把链表接上
        head1.next = pre;
        head2.next = cur;
        return dummy.next;
    }
}
