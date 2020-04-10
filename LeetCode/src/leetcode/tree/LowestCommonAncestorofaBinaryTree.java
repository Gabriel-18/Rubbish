package leetcode.tree;

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 从上往下找
        // 如果能找到 就说明
        // p or q是祖先

        // 找不到 就返回null
        // root是祖先
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左边找不到
        if (left == null) {
            return right;
        }
        // 右边找不到
        if (right == null) {
            return left;
        }
        // 两边都找得到
        // root就是公共祖先了
        return root;
    }
}
