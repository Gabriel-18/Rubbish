package 高频面试题.leetcode;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
// 回溯
public class _113路径总和II {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }


        ArrayList<Integer> path = new ArrayList<>();
//        递归方法嵌套调用的过程中的行为是 复制内存地址
        dfs(root, sum, path);
        return res;
    }

    private void dfs(TreeNode node, int sum, ArrayList<Integer> path) {
        // 递归终止条件 1
        if (node == null) {
            return;
        }

        // 递归终止条件 2
        if (node.val == sum && node.left == null && node.right == null) {
            // 当前结点的值还没添加到列表中，所以要先添加，然后再移除
            path.add(node.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(node.val);
        dfs(node.left, sum - node.val, path);
        // 进入左右分支的 path 是一样的，
        // 这里不用写下面两行，因为一定会调用到 path.remove(path.size() - 1);
//         path.remove(path.size() - 1);
//         path.add(node.val);
        dfs(node.right, sum - node.val, path);
        path.remove(path.size() - 1);
    }
}
