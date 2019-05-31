package leetcode;

public class ConvertSortedArraytoBinarySearchTree {
    /***
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
     * 108. Convert Sorted Array to Binary Search Tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)  {
            return null;
        }
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = toBST(nums,low ,mid - 1 );
        root.right = toBST(nums, mid + 1, high);
        return root;
    }
}
