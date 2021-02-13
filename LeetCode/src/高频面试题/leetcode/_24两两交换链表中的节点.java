package 高频面试题.leetcode;

import leetcode.ListNode;

public class _24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        //遍历原链表，两两进行交换
        while(cur!=null&&cur.next!=null){
            //使用临时结点存储当前第一、二、三个结点
            ListNode first = cur;
            ListNode second = cur.next;
            ListNode third = cur.next.next;
            //交换
            pre.next = second;
            // 反转
            second.next = first;
            // 补链
            first.next = third;

            //cur后移两位，pre后移两位
            pre = first;
            cur = third;
        }
        return dummy.next;
    }

}
