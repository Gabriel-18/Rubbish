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
}