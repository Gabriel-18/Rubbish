package leetcode.tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 判断root的两个子树是否相同
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        // base case
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        // 判断两个子树是否对称
        return isSymmetric(t1.right, t2.left) && isSymmetric(t1.left, t2.right);
    }

}
