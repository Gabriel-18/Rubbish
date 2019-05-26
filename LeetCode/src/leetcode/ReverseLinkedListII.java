package leetcode;

public class ReverseLinkedListII {
    /**
     * https://leetcode.com/problems/reverse-linked-list-ii/
     * 92. Reverse Linked List II
     * time: O(N)
     * space: O(1)
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        for (int i = 1; i < m; i++) {
            cur = cur.next;
            pre = pre.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
