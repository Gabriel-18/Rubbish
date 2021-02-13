package 高频面试题.leetcode;



public class 剑指Offer36二叉搜索树与双向链表 {
    private Node pre = null;
    private Node head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return head;
        }
        inOrder(root);
        // 保证首尾相连
        head.left = pre;
        pre.right = head;

        return head;
    }
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);

        if (head == null) {
            head = node;
        }
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;

        inOrder(node.right);
    }
}
