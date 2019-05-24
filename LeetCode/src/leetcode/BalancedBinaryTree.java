package leetcode;

public class BalancedBinaryTree {
    /**
     * https://leetcode.com/problems/balanced-binary-tree/
     * 110. Balanced Binary Tree
     * 与104. Maximum Depth of Binary Tree (Easy)有点像
     * @param root
     * @return
     */
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        if (Math.abs(1 - r) > 1){
            result = false;
        }
        return Math.max(l, r) + 1;
    }
}
