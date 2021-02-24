package 高频面试题.leetcode;

public class _138复制带随机指针的链表 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // 复制链表
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 对复制的ramdom部分赋值
        cur = head;
        while (cur != null) {
            Node clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // 拆分
        cur = head;
        Node cloneHead = head.next;
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return cloneHead;
    }
}
