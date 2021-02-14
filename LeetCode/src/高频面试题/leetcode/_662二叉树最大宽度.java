package 高频面试题.leetcode;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _662二叉树最大宽度 {
    /**
     * 层序遍历，记录每个节点的索引，当每层遍历完成后计算下一层的最大宽度(链表最后一个元素索引-链表的最前面元素索引+1)
     *   1
     *  2 3
     * 4 5 6 7
     */
    private int maxW = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        queue.add(root);
        indexList.add(1);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                int index = indexList.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                    indexList.add(index * 2);
                }

                if (node.right != null) {
                    queue.add(node.right);
                    indexList.add(index * 2 + 1);
                }
            }
            if (indexList.size() >= 2) {
                maxW = Math.max(maxW, indexList.getLast() - indexList.getFirst() + 1);
            }
        }
        return maxW;
    }

}
