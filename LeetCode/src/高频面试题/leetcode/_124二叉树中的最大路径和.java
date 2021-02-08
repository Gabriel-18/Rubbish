package 高频面试题.leetcode;

import leetcode.TreeNode;

public class _124二叉树中的最大路径和 {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        ans = Math.max(ans, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
