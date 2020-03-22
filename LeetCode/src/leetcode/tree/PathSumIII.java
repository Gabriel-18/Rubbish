package leetcode.tree;

public class PathSumIII {
    /**
     * 指定路径和个数 从上到下即可 终点起点没要求
     * 过root节点和不过root两种情况
     * @param root
     * @param sum
     * @return
     */

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 过root 和 不过root
        int ret = pathSumWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }

    private int pathSumWithRoot(TreeNode root, int sum) {
        int ret = 0;
        // base  case
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            ret++;
        }
        // 计算子树
        int l = pathSumWithRoot(root.left, sum - root.val);
        int r = pathSumWithRoot(root.right, sum - root.val);
        // 求和
        ret += l + r;
        return ret;
    }
}
