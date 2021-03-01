package 高频面试题.牛客;

import leetcode.ListNode;

public class 反转链表 {
    public ListNode ReverseList(ListNode head) {
        //终止条件
        if (head == null || head.next == null)
            return head;
        //保存当前节点的下一个结点
        ListNode next = head.next;
        //从当前节点的下一个结点开始递归调用
        ListNode reverse = ReverseList(next);
        //reverse是反转之后的链表，因为函数reverseList
        // 表示的是对链表的反转，所以反转完之后next肯定
        // 是链表reverse的尾结点，然后我们再把当前节点
        //head挂到next节点的后面就完成了链表的反转。
        next.next = head;
        //这里head相当于变成了尾结点，尾结点都是为空的，
        //否则会构成环
        head.next = null;
        return reverse;
    }
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = null, pre = null, cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }
}
