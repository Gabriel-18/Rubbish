package other;



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

        // 考虑链表长度与倒数k的大小关系
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
