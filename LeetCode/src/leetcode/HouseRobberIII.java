package leetcode;

public class HouseRobberIII {
    /**
     * https://leetcode.com/problems/house-robber-iii/
     * 337. House Robber III
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //第一层开始出发
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        // 从第二层开始出发
        int val2 = rob(root.left) + rob(root.right);

        return Math.max(val1, val2);
    }
}
