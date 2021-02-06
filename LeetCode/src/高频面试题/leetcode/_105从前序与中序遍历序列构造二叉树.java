package 高频面试题.leetcode;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _105从前序与中序遍历序列构造二叉树 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0);
    }
    private TreeNode buildTree(int[] preorder, int preL, int preR, int inL) {
        if (preL > preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        Integer inIndex = map.get(root.val);
        int leftSize = inIndex - inL;
        root.left = buildTree(preorder, preL + 1, preL + leftSize, inL);
        root.right = buildTree(preorder, preL + leftSize + 1, preR, inIndex + 1);
        return root;
    }
}
