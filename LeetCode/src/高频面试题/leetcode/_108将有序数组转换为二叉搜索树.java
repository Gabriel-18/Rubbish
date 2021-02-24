package 高频面试题.leetcode;

import leetcode.TreeNode;

public class _108将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return func(nums,0,nums.length-1);
    }
    public TreeNode func(int[] nums,int left,int right){
        if(left>right)return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=func(nums,left,mid-1);
        root.right=func(nums,mid+1,right);
        return root;
    }

}
