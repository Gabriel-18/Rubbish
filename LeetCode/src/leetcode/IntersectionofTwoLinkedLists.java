package leetcode;

public class IntersectionofTwoLinkedLists {
    /**
     * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
     * 160. Intersection of Two Linked Lists
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = len(headA);
        int lenB = len(headB);

        if (lenA > lenB) {
            while (lenA != lenB) {
                headA = headA.next;
                lenA --;
            }
        } else {
            while (lenA != lenB) {
                headB = headB.next;
                lenB --;
            }
        }

        while (headA != headB) {
            if (headA == null || headB == null) {
                return null;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }


    private int len(ListNode head) {
        int len = 1;
        while (head != null) {
            head = head.next;
            len ++;
        }
        return len;
    }
    // 设 A 的长度为 a + c，B 的长度为 b + c，
    // 其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a
    // 画图
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
