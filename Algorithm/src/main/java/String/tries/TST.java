package string.tries;

public class TST<Value> {
    private Node root;
    private class Node {
        char c;
        Node left, mid, right;
        Value val;
    }

    private Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else {
            return x;
        }
    }

    public Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) {
            x.left = put(x.left, key,val ,d );
        } else if (c > x.c){
            x.right = put(x.right,key ,val ,d );
        } else {
            x.val = val;
        }
        return x;
    }

}
