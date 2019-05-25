package leetcode;

public class PathSumIII {
    /**
     * 437. Path Sum III
     * https://leetcode.com/problems/path-sum-iii/
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //后面两个函数是指从不同的起点出发
        int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == sum) {
            ret ++;
        }

        ret += pathSumStartWithRoot(root.left, sum - root.val) +
                pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
}
