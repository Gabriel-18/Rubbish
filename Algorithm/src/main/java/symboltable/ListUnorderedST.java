package symboltable;

public class ListUnorderedST<Key, Value> implements UnorderedST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        Node cur = first;
        while (cur != null) {
            count ++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public Value get(Key key) {
        Node cur = first;
        while (cur != null) {
            // 比较地址也没问题1
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        //查找给定的键, 找到则更新其值, 否则头插法
        Node cur = first;
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        //否则使用头插法插入一个新节点
        first = new Node(key, value, first);
    }

    @Override
    public void delete(Key key) {
        if (first == null) {
            return;
        }
        // 处理头节点
        if (first.key.equals(key)) {
            first = first.next;
        }
        // 不在头节点
        Node pre = first, cur = first.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                pre.next = cur.next;
                return;
            }
            pre = pre.next;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        double a = 1.00000;
        System.out.println(a);
    }
}
