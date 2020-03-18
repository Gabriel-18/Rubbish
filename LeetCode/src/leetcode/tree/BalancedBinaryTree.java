package leetcode.tree;

public class BalancedBinaryTree {
    /**
     * a binary tree in which the left and right subtrees of
     * every node differ in height by no more than 1.
     * 1.求出左右子树高度
     * 2.高度差大于1 就不符合要求
     * 必须在求出子树高度过程中判断
     * 但是返回值只能一个
     * 所以用全局变量
     * @param root
     * @return
     */
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int r = height(root.left) + 1;
        int l = height(root.right) + 1;
        if (Math.abs(r - l) > 1) {
            result = false;
        }
        return Math.max(r, l);
    }

}
