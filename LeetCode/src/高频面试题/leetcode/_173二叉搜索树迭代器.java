package 高频面试题.leetcode;

import leetcode.TreeNode;

import java.util.Stack;

public class _173二叉搜索树迭代器 {
    class BSTIterator {
        private Stack<TreeNode> stack;
        private TreeNode cur;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            cur = root;
        }

        public int next() {
            if (hasNext()) {
                TreeNode node = stack.pop();
                cur = node.right;
                return node.val;
            }
            return -1;
        }

        public boolean hasNext() {
            if (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            return !stack.isEmpty();
        }
    }
}
