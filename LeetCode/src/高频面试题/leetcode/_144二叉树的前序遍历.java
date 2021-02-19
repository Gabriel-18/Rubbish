package 高频面试题.leetcode;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.right);  // 先右后左，保证左子树先遍历
            stack.push(node.left);
        }
        return ret;
    }
}
