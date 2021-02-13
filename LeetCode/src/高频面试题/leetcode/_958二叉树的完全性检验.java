package 高频面试题.leetcode;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _958二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while(cnt -- > 0) {
                node = queue.poll();
                // 上一次不为空
                if (node == null) {
                    flag = true;
                    continue;
                }
                // 下一次为空
                if (flag == true) {
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
}
