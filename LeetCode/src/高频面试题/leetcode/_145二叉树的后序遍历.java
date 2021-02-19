package 高频面试题.leetcode;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _145二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}
