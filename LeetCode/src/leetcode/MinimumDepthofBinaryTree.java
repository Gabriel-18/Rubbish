package leetcode;

public class MinimumDepthofBinaryTree {
    /**
     * 111. Minimum Depth of Binary Tree
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/
     * 画图, 从任意节点观察
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        // 子树为空
        if (root == null) {
            return 0;
        }

        // 计算当前节点子树
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // 只有一个子节点
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        //子树 + 1
        return Math.min(left, right) + 1;
    }
}
