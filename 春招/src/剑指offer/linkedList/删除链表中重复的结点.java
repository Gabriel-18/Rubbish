package 剑指offer.linkedList;

import 剑指offer.ListNode;

// 数据排序了的
// 重复的数据必然连续
public class 删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead) {
        // 只有0个或1个节点
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        // 当前节点是重复节点
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                // 跳过值与当前节点相同的全部节点，找到第一个与当前节点不同的节点
                next = next.next;
            // 从第一个与当前结点不同的结点继续递归
            return deleteDuplication(next);
        } else { // 当前节点不是重复节点
            // 保留当前节点，从下一个节点继续递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }


    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 新建一个头结点，防止链表中头结点是重复节点被删除··
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode prev = head;
        ListNode cur = pHead;

        while (cur != null) {
            // 这个条件容易写错地方
            boolean flag = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                flag = true;
            }
            if (flag == true) {
                // 删除
                prev.next = cur.next;
                // 链表以重复节点结尾 可以直接返回结果
                if (cur.next == null) {
                    return head.next;
                }
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head.next;
    }
}
