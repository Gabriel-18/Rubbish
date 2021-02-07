package 剑指offer;

public class 平衡二叉树 {
    public boolean res = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getHeight(root, 1);
        return res;
    }

    private int getHeight(TreeNode head, int level) {
        if (head == null) {
            return level;
        }
        int l = getHeight(head.left, level + 1);
        if (res == false) {
            return level;
        }

        int r = getHeight(head.right, level +1);
        if (res == false) {
            return level;
        }

        if (Math.abs(l - r) > 1) {
            res = false;
        }
        return Math.max(r, l);
    }
}
