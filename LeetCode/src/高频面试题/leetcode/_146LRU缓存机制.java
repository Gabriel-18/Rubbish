package 高频面试题.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _146LRU缓存机制 {
    public class LRUCache {
        
        class Node {
            int key;
            int value;
            Node pre;
            Node next;
            public Node() {

            }
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        // 模拟Cache
        private Map<Integer, Node> cache = new HashMap<Integer, Node>();
        private int size;
        private int capacity;
        private Node head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new Node();
            tail = new Node();
            // 模拟内存
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node cur = cache.get(key);
            if (cur == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(cur);
            return cur.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                Node newNode = new Node(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    Node tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private Node removeTail() {
            Node node = tail.pre;
            removeNode(node);
            return node;
        }
    }


}
