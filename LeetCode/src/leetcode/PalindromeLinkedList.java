package leetcode;

public class PalindromeLinkedList {
    /**
     * 234. Palindrome Linked List
     * https://leetcode.com/problems/palindrome-linked-list/
     * 切半
     * 后半段反转
     * 然后比较
     * 画图
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * 偶数节点
         * slow指向下一个节点
         */
        if (fast != null) {
            slow = slow.next;
        }

        cut(head, slow);
        return isEqual(head, reverse(slow));
    }
    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            //备份
            ListNode nextNode = head.next;
            //逆转
            head.next = newHead;
            //更新
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }

    /**
     * 判断是否相等
     * 奇数时可以忽略最后一个数
     * @param l1
     * @param l2
     * @return
     */
    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
