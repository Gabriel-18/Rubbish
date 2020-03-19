package leetcode.tree;

public class DiameterofBinaryTree {
    private int diameter = 0;
    /**
     * 就计算某个节点的左右子树高度之和
     * 1.左子树高度
     * 2.右子树高度
     * 3.求和
     *
     * 4.取最大值
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    /**
     * 求某个节点的高度
     * @param root
     * @return
     */
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        diameter = Math.max(diameter, (l + r));
        return Math.max(l,r) + 1;
    }
}
