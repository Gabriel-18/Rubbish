package 高频面试题.leetcode;

import java.util.*;

/**
 * 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
 * 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
 */
public class _39组合总和 {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;

        if (len == 0) {
            return ret;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(candidates, 0, len, target, path);
        return ret;
    }

    private void dfs(int[] candidates, int begin, int len, int target, ArrayList<Integer> path) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            ret.add(new ArrayList<>(path));
            return;
        }else {
            for (int i = begin; i < len; i++) {
                // 重点理解这里剪枝，前提是候选数组已经有序，
                if (target - candidates[i] < 0) {
                    break;
                }

                path.add(candidates[i]);
                dfs(candidates, i, len, target - candidates[i], path);
                path.remove(path.size() - 1);
            }
        }
    }
}
