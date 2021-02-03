package other.linkedList;

import other.ListNode;

/**
 * 理论上讲要维护三个变量
 * pre haed next
 * 每反转一次
 * 就意味着
 * 一个旧链表的断开
 * 一个新链表的生成
 *画个图就很清楚了
 */
public class 反转链表 {
    public ListNode ReverseList(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            //记录当前节点的下一个节点位置
            ListNode next = head.next;
            // 当前节点指向前一个节点
            head.next = newList.next;
            // 指针后移
            newList.next = head;
            // 指针后移
            head = next;

        }
        return newList.next;
    }
    public ListNode ReverseList3(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            // 记录next 反转后会丢失
            next = head.next;
            // 反转 链表一分为二了
            head.next = pre;
            // 前端链表的头部
            pre = head;
            // 后端链表的头部
            head = next;
        }
        return pre;
    }
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList2(next);
        next.next = head;
        return newHead;
    }
}
