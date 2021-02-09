package 剑指offer;

public class 在O1时间内删除链表节点 {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return head;
        if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点
            // 直接可以把下一个节点的值赋给该节点
            // 然后就做删除操作
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else { // 尾节点
            if (head == tobeDelete)
                // 只有一个节点
                head = null;
            else {
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }
}
