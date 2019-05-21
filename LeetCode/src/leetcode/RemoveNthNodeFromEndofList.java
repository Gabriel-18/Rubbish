package leetcode;

public class RemoveNthNodeFromEndofList {
    /***
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     * 19. Remove Nth Node From End of List
     * 距离相差n
     * 必然相隔n + 1个点 slow最后显然在待删节点之前
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;

        // 使两者相距 n
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
