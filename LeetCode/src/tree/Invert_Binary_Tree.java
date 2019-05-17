package tree;

public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 语义
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

         // 最后反转root的左右子树
        root.left = right;
        root.right = left;
        return root;
    }


}
