package leetcode;

import java.util.Stack;

public class AddTwoNumbersII {
    /**
     * https://leetcode.com/problems/add-two-numbers-ii/
     * 445. Add Two Numbers II
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1stack = buildStack(l1);
        Stack<Integer> l2stack = buildStack(l2);

        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1stack.isEmpty() || !l2stack.isEmpty() || carry != 0) {
            int x = l1stack.isEmpty() ? 0 : l1stack.pop();
            int y = l2stack.isEmpty() ? 0 : l2stack.pop();
            int sum = x + y + carry;

            //头插法
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;

            carry = sum / 10;
        }
        return head.next;
    }
    private Stack<Integer> buildStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        return stack;
    }
}
