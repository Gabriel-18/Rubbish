package 高频面试题.leetcode;

import leetcode.ListNode;

public class _61旋转链表 {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null){
                return head;
            }

            // 1. 找尾节点，形成环形链表
            ListNode tail = head;
            int length = 1;
            while(tail.next != null){
                length++;
                tail = tail.next;
            }
            tail.next = head;

            // 2. 尾节点移动 length - k 步
            k = k % length;
            for(int i = 0; i < length - k; i++){
                tail = tail.next;
            }

            // 3. 找到头节点，断开头尾连接
            head = tail.next;
            tail.next = null;
            return head;
        }
    }

}
