package leetcode.tree;

import leetcode.ListNode;

public class ConvertSortedListtoBinarySearchTree {
    // 和上一道一个套路
    // 只是在寻找中值比较难搞
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;


        // 将链表一分为三
        // 左 root 右
        preMid.next = null;
        // 建root
        TreeNode root = new TreeNode(mid.val);
        // 处理左
        root.left = sortedListToBST(head);
        // 处理右
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode preMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
