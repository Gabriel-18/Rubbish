package 高频面试题.leetcode;

import leetcode.TreeNode;

public class _530二叉搜索树的最小绝对差 {
    //差值的最小值
    int min = Integer.MAX_VALUE;
    //前一个节点
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        //边界条件判断
        if (root == null)
            return;
        //左子树
        inorder(root.left);
        //对当前节点的操作
        if (prev != null)
            min = Math.min(min, root.val - prev.val);
        prev = root;
        //右子树
        inorder(root.right);
    }

}
