package leetcode.tree;

public class MergeTwoBinaryTrees {
    /**
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        // 都存在时 需要合并
        TreeNode root = new TreeNode(t1.val + t2.val);
        // 处理子树
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);

        return root;
    }
}