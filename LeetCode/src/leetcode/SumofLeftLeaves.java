package leetcode;

public class SumofLeftLeaves {
    /**
     * https://leetcode.com/problems/sum-of-left-leaves/description/
     * 404. Sum of Left Leaves
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.right) + sumOfLeftLeaves(root.left);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }

        return node.left == null && node.right == null;
    }
}
