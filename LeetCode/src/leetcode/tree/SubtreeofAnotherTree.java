package leetcode.tree;

public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        // 过父节点
        // 过子节点
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        // base case
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        // 判断父节点是否相同
        if (s.val != t.val) {
            return false;
        }
        // 判断子节点是否相同
        return isSubtreeWithRoot(s.right, t.right) && isSubtreeWithRoot(s.left, t.left);
    }
}
