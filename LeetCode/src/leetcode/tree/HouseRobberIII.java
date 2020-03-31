package leetcode.tree;

public class HouseRobberIII {
    // 两种可能性
    // 带头和不带头 分别求解
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val1 = root.val;
        // 间隔求解 要头
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }

        // 不要头
        int val2 = rob(root.left) + rob(root.right);

        return Math.max(val1, val2);
    }
}
