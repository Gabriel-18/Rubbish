package leetcode;

public class MaximumDepthofBinaryTree {
    /**
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
     * 104. Maximum Depth of Binary Tree
     * 等于左右子树最高的加一
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
