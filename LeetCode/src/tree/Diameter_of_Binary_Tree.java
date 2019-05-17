package tree;

public class Diameter_of_Binary_Tree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        //转折节点
        max = Math.max(max, leftDepth + rightDepth);
        //非转折节点
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
