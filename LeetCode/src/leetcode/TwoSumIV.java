package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV {
    /**
     * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
     * 653. Two Sum IV - Input is a BST
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int sum = nums.get(i) + nums.get(j);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                i ++;
            } else {
                j --;
            }
        }
        return false;
    }

    // 产生有序
    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}
