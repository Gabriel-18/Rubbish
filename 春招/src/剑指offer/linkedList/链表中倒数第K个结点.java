package 剑指offer.linkedList;


import 剑指offer.ListNode;

/**
 * 设置两个指针
 * p1 p2 均指向 head
 * 先让p1走k步
 * 然后p1 p2 同时行走
 * 当p1走到链表结尾时
 * p2 恰好走到倒数k的位置处
 * 技巧
 */
public class 链表中倒数第K个结点 {


    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        while (node1 != null && k-- > 0) {
            node1 = node1.next;
        }

        // 链表都没那么长
        if (k > 0) {
            return null;
        }

        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }
}
