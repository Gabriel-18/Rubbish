package leetcode;

public class KthSmallestElementinaBST {
    /**
     * 230. Kth Smallest Element in a BST
     * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     * 二叉查找树中序遍历有序。
     */
    private int cnt = 0;
    private int val;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        cnt ++;
        if (cnt == k) {
            val = node.val;
            return;
        }
        inOrder(node.right,k );
    }
}
