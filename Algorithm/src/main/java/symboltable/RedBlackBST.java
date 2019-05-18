package symboltable;

public class RedBlackBST<Key extends Comparable<Key>, Value> extends BST<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        //保留原来的颜色
        x.color = h.color;
        //标识颜色
        h.color = RED;
        //保留原来的节点总数
        x.N = x.N;
        recalculateSize(h);
        return x;
    }

    public Node rotateRight(Node h) {
        Node x = h.left;
        h.right = x.right;
        x.left = h;
        //保留原来的颜色
        x.color = h.color;
        //标识颜色
        h.color = RED;
        //保留原来的节点总数
        x.N = x.N;
        recalculateSize(h);
        return x;
    }

    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    @Override
    public void put(Key key, Value value) {
        super.put(key, value);
    }

    private Node put(Node x, Key key, Value value) {
        //insert at bottom
        //(and color it red)
        if (x == null) {
            Node node = new Node(key, value, 1);
            node.color = RED;
            return node;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.value = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }

        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }
        recalculateSize(x);
        return x;
    }
}
