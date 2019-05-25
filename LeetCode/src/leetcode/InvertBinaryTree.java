package leetcode;

public class InvertBinaryTree {
    /**
     * https://leetcode.com/problems/invert-binary-tree/
     * 226. Invert Binary Tree
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //交换两个节点
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        //递归执行
        invertTree(root.left);
        invertTree(root.right);

        //官方题解
        //TreeNode right = invertTree(root.right);
        //TreeNode left = invertTree(root.left);
        //root.left = right;
        //root.right = left;



        return root;
    }
}
