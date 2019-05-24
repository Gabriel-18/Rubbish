package leetcode;

public class DiameterofBinaryTree {
    /**
     * 543. Diameter of Binary Tree
     * https://leetcode.com/problems/diameter-of-binary-tree/
     * 自底向上
     */
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leafDepth = depth(root.left);
        int rightDepth = depth(root.right);
        // 底层和上层比较
        max = Math.max(max, leafDepth + rightDepth);
        return Math.max(leafDepth, rightDepth) + 1;
    }
}
