package leetcode;

public class ReverseLinkedList {
    /**
     * 206. Reverse Linked List
     * https://leetcode.com/problems/reverse-linked-list/
     * 简单的来讲 我们需要维护三个变量
     * 头节点的前一个节点 newNode
     * 头节点 head
     * 头节点的下一个节点 next
     */
    public ListNode reverseList(ListNode head) {
        // 当前头节点前面的那个节点
        ListNode newNode = null;
        // 当前头节点后面的那个节点
        ListNode next = null;
        while (head != null) {
            // 必须记录它 不然链表一反转就断了
            next = head.next;
            // 这就是反转的那行 如果没有记录它后面的那个节点 链表就断了
            head.next = newNode;
            //  反转完一次后 这个head节点相对后面那个next 变成了前一个节点了
            // 维护这个相对位置
            newNode = head;
            // next变成后面剩下的链表的头节点了
            // 维护相对位置
            head = next;
        }
        // 反转结束的时候 后面那部分肯定就没了 而相对后面那部分的前面的节点自然就成了头节点
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
