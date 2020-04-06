package leetcode.tree;

public class ConvertBSTtoGreaterTree {

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    private void traver(TreeNode node) {
        if (node == null) {
            return;
        }
        // BST
        // 右子树大于root
        // 让根变大
        // 先往右走
        // 然后往左走
        traver(node.right);
        sum += node.val;
        node.val = sum;
        traver(node.left);
    }
}
