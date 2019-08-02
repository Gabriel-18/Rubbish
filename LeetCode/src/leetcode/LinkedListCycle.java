package leetcode;

public class LinkedListCycle {
    /**
     * 141. Linked List Cycle
     * https://leetcode.com/problems/linked-list-cycle/
     * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，
     * 如果存在环，那么这两个指针一定会相遇。
     * 这个算法只能当作结论记住吧！！！
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode l1 = head, l2 = head.next;
        // 不可能有环的条件
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) { // 相遇
                return true;
            }
            // 正常移动
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }


    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
