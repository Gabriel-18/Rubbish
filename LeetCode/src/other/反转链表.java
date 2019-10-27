package other;

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
