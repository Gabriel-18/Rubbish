package 高频面试题.leetcode;

import leetcode.TreeNode;

public class _剑指Offer54二叉搜索树的第k大节点 {
    private TreeNode ret;
    private int cnt = 0;
    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return ret.val;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k) {
            return;
        }
        inOrder(root.right, k);
        cnt++;
        if (cnt == k) {
            ret = root;
            return;
        }
        inOrder(root.left, k);
    }
}
