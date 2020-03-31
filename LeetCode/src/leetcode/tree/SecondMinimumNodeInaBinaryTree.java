package leetcode.tree;

public class SecondMinimumNodeInaBinaryTree {
    // 根节点比子节点小
    // 第二个小的肯定在子节点中
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        // 往左找
        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }
        // 往右找
        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }
        // 左右子树中最小的那个是答案
        if (rightVal != -1 && leftVal != -1) {
            return Math.min(rightVal, leftVal);
        }

        if (leftVal != -1) {
            return leftVal;
        }

        return rightVal;
    }
}
