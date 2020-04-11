package leetcode.tree;

public class ConvertSortedArraytoBinarySearchTree {
    // 二叉查找树特点
    // 左 < root < 右
    // 有序数组
    // 建树 先root 后左 再右
    // 标准前序遍历

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        // 建根
        TreeNode root = new TreeNode(nums[mid]);
        // 建左树
        root.left = buildBST(nums, l, mid - 1);
        // 建右树
        root.right = buildBST(nums, mid + 1, r);
        return root;
    }
}
