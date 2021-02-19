package 高频面试题.leetcode;

import leetcode.TreeNode;

public class _222完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left, right = root.right;
        int leftHeight = getHeight(left);
        int rightHeight = getHeight(right);
        // 左边是完美二叉树
        if (leftHeight == rightHeight){
            return (1 << leftHeight) + countNodes(right);
        }else{
            // 右边是完美二叉树
            return (1<< rightHeight) + countNodes(left);
        }
    }

    // 算个高度
    public int getHeight(TreeNode node){
        if (node == null){
            return 0;
        }
        int height = 1;
        while (node.left != null){
            height++;
            node = node.left;
        }
        return height;
    }
}
