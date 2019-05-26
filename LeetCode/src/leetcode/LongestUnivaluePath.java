package leetcode;

public class LongestUnivaluePath {
    /**
     * 687. Longest Univalue Path
     * https://leetcode.com/problems/longest-univalue-path/
     * 与543. Diameter of Binary Tree 有点相似
     * @param root
     * @return
     */
    private int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leafPath = root.left != null && root.left.val == root.val ? left + 1: 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1: 0;

        //某个点的最大情况
        path = Math.max(path, leafPath + rightPath);
        // 向上只能返回单边最大
        return Math.max(leafPath, rightPath);

    }
}
