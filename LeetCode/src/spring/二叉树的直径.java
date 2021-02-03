package spring;

import leetcode.tree.TreeNode;

public class 二叉树的直径 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右深度
        int l = helper(root.left);
        int r = helper(root.right);
        // 记录最大的直径
        max = Math.max(l + r, max);
        // 向上一层返回 深度+1
        return Math.max(l, r) + 1;
    }
}
