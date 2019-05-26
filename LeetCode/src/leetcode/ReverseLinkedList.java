package leetcode;

public class ReverseLinkedList {
    /**
     * 206. Reverse Linked List
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = newNode;
            newNode = head;
            head = next;
        }
        return newNode;
    }

    public ListNode reverseList2(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList2(next);

        newHead.next = head;
        head.next = null;
        return newHead;
    }
}
