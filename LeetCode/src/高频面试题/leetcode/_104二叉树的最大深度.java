package 高频面试题.leetcode;

import leetcode.TreeNode;

public class _104二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
