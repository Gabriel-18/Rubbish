package leetcode.tree;

public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        // 特殊情况
        // 题目说的到叶子的最小值
        // 如果叶子不存在 那自然只能算另外一个
        if (l == 0 || r == 0) {
            return l + r + 1;
        }
        // 上层+1
        return Math.min(l, r) + 1;
    }
}
