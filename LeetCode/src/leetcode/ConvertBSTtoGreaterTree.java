package leetcode;

public class ConvertBSTtoGreaterTree {
    /***
     * 538. Convert BST to Greater Tree
     * https://leetcode.com/problems/convert-bst-to-greater-tree/
     * BST的性质 右子树大于根节点
     * @param root
     * @return
     */
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    private void traver(TreeNode node) {
        // 向上返回
        if (node == null) {
            return;
        }
        // 先遍历右子树
        traver(node.right);
        sum += node.val;
        node.val = sum;

        traver(node.left);
    }
}
