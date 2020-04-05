package leetcode.tree;

public class TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        // 当前值大于最大值
        // 去左子树里面寻找答案
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }


        // 当前值小于最小值
        // 去右子树里面寻找答案
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        // trim the tree
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
