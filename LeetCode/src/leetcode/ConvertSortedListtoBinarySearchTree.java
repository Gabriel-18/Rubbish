package leetcode;

public class ConvertSortedListtoBinarySearchTree {
    /**
     * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
     * 109. Convert Sorted List to Binary Search Tree
     * 和108. Convert Sorted Array to Binary Search Tree (Easy)有点类似
     * 语义产生sortedListToBST
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        // 断开
        preMid.next = null;
        TreeNode t = new TreeNode(mid.val);
        // 左边
        t.left = sortedListToBST(head);
        // 右边
        t.right = sortedListToBST(mid.next);
        return t;
    }

    /**
     * For an even sized list, any of the two middle elements can act as the root of the BST.
     * 语义返回中间节点
     * @param head
     * @return
     */
    private ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
