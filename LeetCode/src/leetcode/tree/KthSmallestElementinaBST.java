package leetcode.tree;

public class KthSmallestElementinaBST {
    // 寻找第k小的元素
    // 二叉搜索树
    // 中序
    private int cnt = 0;
    private int val;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        // 中序遍历
        // 其实就是第二次访问的输出
        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            val = root.val;
            return;
        }
        inOrder(root.right, k);
    }
}
