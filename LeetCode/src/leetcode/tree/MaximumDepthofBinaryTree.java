package leetcode.tree;
public class MaximumDepthofBinaryTree {
    /**
     * 求树的高度
     * 求出左右子树的高度
     * 分别加一即是左右子树的高度
     * 两者取最大值就是树的高度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left) + 1;
        int r = maxDepth(root.right) + 1;
        return Math.max(l,r);
    }
}
