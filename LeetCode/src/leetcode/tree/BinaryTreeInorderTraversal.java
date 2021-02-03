package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // 处理左子树的过程
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 到底了
            TreeNode node = stack.pop();
            ret.add(node.val);
            // 处理完左子树
            // 处理右子树
            cur = node.right;
        }
        return ret;
    }
}
