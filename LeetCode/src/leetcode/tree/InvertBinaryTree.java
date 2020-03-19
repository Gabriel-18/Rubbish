package leetcode.tree;

public class InvertBinaryTree {
    /**
     * 翻转树
     * 换句说就是左右节点交换位置
     * 如何实现？
     * 就是让一个节点的左子树指向原来右子树的区域
     * 右子树指向原来左子树的区域
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 本质是前序遍历
        // 交换后 原来的右节点就没了
        // 所以需要备份
        TreeNode right = root.right;
        // 右指向了左
        root.right = invertTree(root.left);
        // 左指向了右
        root.left = invertTree(right);
        // 返回根节点
        return root;
    }
}
