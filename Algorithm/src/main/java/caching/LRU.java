package caching;

import java.util.HashMap;

public class LRU<K,V> {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    private class Node {
        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public LRU(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);

        //创建两个空节点
        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.pre = head;
    }

    private V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);
        // 去掉
        unlink(node);
        // 放表头
        appendHead(node);

        return node.v;
    }

    private void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        appendHead(node);

        if (map.size() > maxSize) {
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }
    private Node removeTail() {
        // 尾节点前一个节点
        Node node = tail.pre;
        // node前一个节点
        Node pre = node.pre;

        // 跳过中间那个节点
        tail.pre = pre;
        pre.next = tail;

        // 去掉这个节点
        node.pre = null;
        node.next = null;

        return node;
    }

    /**
     * 将一个节点链接到空头节点之后
     * @param node
     */
    private void appendHead(Node node) {
        Node next = head.next;
        // 链接头节点后面那个节点
        node.next = next;
        next.pre = node;

        // 链接头节点
        node.pre = head;
        head.next = node;
    }

    /**
     * 将一个节点从双链表中去掉
     * @param node
     */
    private void unlink(Node node) {
        // 前一个节点
        Node pre = node.pre;
        // 后一个节点
        Node next = node.next;

        //跳过中间节点
        pre.next = next;
        next.pre = pre;

        // 制空
        node.pre = null;
        node.next = null;
    }

}
