package 剑指offer.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class 从尾到头打印链表 {

    // 递归
    // debug理解这个递归过程
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }


    public int[] reversePrint(ListNode head) {
//        ArrayList<Integer> ret = new ArrayList<>();
        ListNode pre = null, next = null;
        int count = 0;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }

        int[] ret = new int[count];
        head = pre;
        int i = 0;
        while (head != null) {
            ret[i++] = head.val;
//            ret.add(head.val);
            head = head.next;
        }
//        int[] f = ret.stream().mapToInt(k->k).toArray();
//        int[] f = ret.stream().mapToInt(Integer::intValue).toArray();

        return ret;
    }


    /**
     * easy
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {

        // 维护三个指针
        // pre
        // head
        // next
        ListNode pre = null, head = null, next = null;
        // 画图可以很显然发现
        // 退到最后 pre指向最后一个节点
        // head next 指向空节点
        while (head != null) {
            // 备份
            next = head.next;
            // 反转
            head.next = pre;
            // 分别往后退
            pre = head;
            head = next;
        }


        // 收集数据 这个返回值的问题 通俗来说就是能不能日进去
//        ArrayList<Integer> ret = new ArrayList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        head = pre;
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
