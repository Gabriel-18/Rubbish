package leetcode;

public class SubtreeofAnotherTree {
    /**
     * 572. Subtree of Another Tree
     * https://leetcode.com/problems/subtree-of-another-tree/description/
     * 思路和437差不多
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }

        if (t == null || s == null) {
            return false;
        }

        if (t.val != s.val) {
            return false;
        }

        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);

    }
}
