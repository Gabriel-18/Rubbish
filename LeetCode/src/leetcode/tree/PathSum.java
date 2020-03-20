package leetcode.tree;

public class PathSum {
    /**
     * 求root到叶的路径和
     * 不可能两头都取
     * a root-to-leaf path
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // base case
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        // 对子树求解
        boolean l = hasPathSum(root.left, sum - root.val);
        boolean r = hasPathSum(root.right, sum - root.val);
        return l || r;
    }
}
