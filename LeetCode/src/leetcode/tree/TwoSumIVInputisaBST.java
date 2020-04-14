package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputisaBST {
    // 符合条件的结果 可能不在同一个根的 左右子树
    // 利用有序数组做
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
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    // 中序收集有序数组
    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }

        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}
