package leetcode.tree;

public class MinimumAbsoluteDifferenceinBST {

    private int minDiff = Integer.MAX_VALUE;
    // 记录上一个node
    private TreeNode preNode = null;
    // 中序遍历时相邻的元素 有序
    // 两个之差可能最小
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (preNode != null) {
            minDiff = Math.min(minDiff, root.val - preNode.val);
        }
        preNode = root;
        inOrder(root.right);
    }
}
