package spring;

import leetcode.tree.TreeNode;

public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
         if (t1 == null) {
             return t2;
         }
         if (t2 == null) {
             return t1;
         }
         // 合并当前
        TreeNode mergeNode = new TreeNode(t1.val + t2.val);
         // 左边合并
        mergeNode.left = mergeTrees(t1.left, t2.left);
        // 右边合并
        mergeNode.right = mergeTrees(t1.right, t2.right);
        return mergeNode;
    }
}
