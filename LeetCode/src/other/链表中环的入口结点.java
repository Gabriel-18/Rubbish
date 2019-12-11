package other;

/**
 * 设置两个指针
 * slow fast
 * fast 比 slow每次多走一步
 * 这里有个结论
 * 当两个指针相遇时
 * 起点和相遇点 距 交点的距离相等
 * 也即是说
 * 让其中一个指向起点 然后同时同速
 * 两者相遇处既是答案
 */
public class 链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead, fast = pHead;
//        do {
//
//            fast = fast.next.next;
//            slow = slow.next;
//        } while (slow != fast);

        /**
         * do while
         * 代码更加简洁
         */
        fast = fast.next.next;
        slow = slow.next;
        while (slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
