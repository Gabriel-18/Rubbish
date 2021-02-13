package 高频面试题.leetcode;

import leetcode.TreeNode;

/**
 * 其实是分为三步：
 *
 * 首先将根节点的左子树变成链表
 * 其次将根节点的右子树变成链表
 * 最后将变成链表的右子树放在变成链表的左子树的最右边
 * 这就是一个递归的过程，递归的一个非常重要的点就是：不去管函数的内部细节是如何处理的，我们只看其函数作用以及输入与输出。对于函数flatten来说：
 *
 * 函数作用：将一个二叉树，原地将它展开为链表
 * 输入：树的根节点
 * 输出：无
 * 那我们就直接根据三步来写程序就可以了
 *
 */
public class _114二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        //将根节点的左子树变成链表
        flatten(root.left);
        //将根节点的右子树变成链表
        flatten(root.right);

        TreeNode temp = root.right;
        //把树的右边换成左边的链表
        root.right = root.left;
        //记得要将左边置空
        root.left = null;
        //找到树的最右边的节点
        while(root.right != null) {
            root = root.right;
        }
        //把右边的链表接到刚才树的最右边的节点
        root.right = temp;
    }

}
