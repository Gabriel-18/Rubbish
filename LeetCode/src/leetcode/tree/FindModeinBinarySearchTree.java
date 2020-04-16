package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class FindModeinBinarySearchTree {
    private TreeNode preNode = null;
    private int curCnt = 1;
    private int maxCnt = 1;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        int idx = 0;
        for (Integer num : maxCntNums) {
            ret[idx++] = num;
        }
        return ret;
    }

    // 中序遍历
    // 过程中统计出现次数最多
    // 注意次数可能有同样多的
    // 所以答案不唯一
    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nums);
        // 统计次数
        if (preNode != null) {
            if (preNode.val == root.val) {
                curCnt++;
            } else {
                curCnt = 1;
            }
        }
        // 更新数组
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(root.val);
        } else if (curCnt == maxCnt) {
            nums.add(root.val);
        }
        // 记录上一个节点
        preNode = root;
        inOrder(root.right, nums);
    }
}


