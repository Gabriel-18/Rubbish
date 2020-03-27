package leetcode.tree;

/**
 * 从下往上做
 * 先左后右
 * 左子树和root的值相同 leftPath = l + 1 否则为0
 * 右子树和root的值相同 leftPath = r + 1 否则为0
 * path = leftPath + rightPath
 *
 */
public class LongestUnivaluePath {
    private int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        int leftPath;
        int rightPath;
        if (root.left != null && root.left.val == root.val) {
            leftPath = l + 1;
        } else {
            leftPath = 0;
        }

        if (root.right != null && root.right.val == root.val) {
            rightPath = r + 1;
        } else {
            rightPath = 0;
        }
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath,rightPath);

    }
}
