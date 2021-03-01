package 高频面试题.牛客;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class 设计LRU缓存结构 {

    class Node {
        private int val;
        private int key;
        private Node pre = null;
        private Node next = null;

        private Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private Map<Integer, Node> cache = new HashMap();
    private Node head = new Node(-1, -1);  //头节点
    private Node tail = new Node(-1, -1);  //尾节点
    private int size;
    private int capacity;
    private int k = 0;

    public int[] LRU(int[][] operators, int capacity) {
        // write code here
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
        ArrayList<Integer> ret = new ArrayList<>();

        for (int i = 0, j = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {   //获取数组中开头为1（set操作）的元素个数
                set(operators[i][1], operators[i][2]);  //set(key,val)
            } else {   //获取数组中开头为2（get操作）的元素个数
                ret.add(get(operators[i][1]));  //get(key)
            }
        }

        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void set(int key, int val) {
        //判断是否存在key
        Node node = cache.get(key);
        if (node == null) {
            Node newnode = new Node(key, val);
            cache.put(key, newnode);
            addToHead(newnode);
            size++;
            if (size > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.val = val;
            moveToHead(node);
        }
    }

    private Node removeTail() {
        Node ret = tail.pre;
        removeNode(ret);
        return ret;
    }


    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果不存在key 则返回-1
        // 如果存在key，先将该key的结点删除，然后再将此节点插入到链表的表头
        moveToHead(node);
        return node.val;
    }

    // 移动到表头
    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    //将节点插入到表头
    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;

    }
}