package 剑指offer.linkedList;
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
            return null;
        }

        RandomListNode cur = pHead;
        // 在每个节点的后面插入复制的节点
        while (cur != null) {
            // 复制
            RandomListNode clone = new RandomListNode(cur.label);
            // 插入
            clone.next = cur.next;
            cur.next = clone;
            // 更新
            cur = clone.next;
        }
        // 对复制节点的random链接进行赋值
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            // 备份next
            RandomListNode next = cur.next;
            // 同一类的链表节点连接
            cur.next = next.next;
            // 后移
            cur = next;
        }
        return pCloneHead;
    }
}
