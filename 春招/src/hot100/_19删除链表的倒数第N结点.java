package hot100;

public class _19删除链表的倒数第N结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new  ListNode(-1);
        dummy.next = head;
        // 画图
        ListNode fast = head, slow = dummy;
        while (n != 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
