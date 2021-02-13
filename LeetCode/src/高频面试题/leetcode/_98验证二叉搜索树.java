package 高频面试题.leetcode;

import leetcode.TreeNode;

public class _98验证二叉搜索树 {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        boolean left = isValidBST(root.left);
        // 用前面一个节点和当前节点比较
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        // 记录前一个节点
        // 左根右
        // 左子树记录一次
        // 返回后更新一次
        pre = root;
        //访问右子树
        boolean right = isValidBST(root.right);
        return left && right;
    }

}
