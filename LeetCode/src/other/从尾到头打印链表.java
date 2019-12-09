package other;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     * 表示不会啊！！！！
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);

        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
//        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> stack = new LinkedList<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}
