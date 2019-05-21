package leetcode;

public class RemoveDuplicatesfromSortedList {
    /***
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     * 83. Remove Duplicates from Sorted List
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while ( cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
