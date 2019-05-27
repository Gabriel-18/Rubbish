package leetcode;

public class SecondMinimumNodeInaBinaryTree {
    /**
     * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
     * 671. Second Minimum Node In a Binary Tree
     * 一个节点要么具有 0 个或 2 个子节点，如果有子节点，那么根节点是最小的节点
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        int leftVal = root.left.val;
        int rightVal = root.right.val;

        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }
        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }

        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }

        if (leftVal != -1) {
            return leftVal;
        }
        return rightVal;
    }
}
