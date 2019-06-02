package leetcode;

public class MinimumAbsoluteDifferenceinBST {
    /**
     * 530. Minimum Absolute Difference in BST
     * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
     * 中序遍历为有序
     * 计算两个节点之差
     * @param root
     * @return
     */
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (preNode != null) {
            minDiff = Math.min(minDiff, node.val - preNode.val);
        }
        preNode = node;
        inOrder(node.right);
    }
}
