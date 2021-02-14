package 高频面试题.leetcode.补充题;

public class 排序奇升偶降链表 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    // 这一步注意细节
    public static ListNode[] getTwoList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode l3 = l2;
        ListNode copyNode = null;
        while (l2 != null && l2.next != null) {
            l1.next = l1.next.next;
            l1 = l1.next;

            l2.next = l2.next.next;
            l2 = l2.next;
        }
        l1.next = l3;
        return new ListNode[]{head, l3};
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(9);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(3);
        ListNode[] twoList = getTwoList(head);
        ListNode l1 = twoList[0];
        ListNode l2 = reverse(twoList[1]);
        ListNode res = mergeListNode(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}