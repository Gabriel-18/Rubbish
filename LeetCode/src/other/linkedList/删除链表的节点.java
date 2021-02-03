package other.linkedList;

public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        //初始化一个虚拟节点
        ListNode dummy = new ListNode(0);
        //让虚拟节点指向头结点
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                //如果找到要删除的结点，直接把他删除
                pre.next = cur.next;
                break;
            }
            //如果没找到，pre指针和cur指针都同时往后移一步
            pre = cur;
            cur = cur.next;
        }
        //最后返回虚拟节点的下一个结点即可
        return dummy.next;
    }

}
