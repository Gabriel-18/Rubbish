package 高频面试题.leetcode;

import java.util.*;

public class _40组合总和II {

    public class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int len = candidates.length;

            if (len == 0) {
                return res;
            }

            // 关键步骤
            Arrays.sort(candidates);

            ArrayList<Integer> path = new ArrayList<>(len);
            dfs(candidates, 0, target, path);
            return res;
        }

        /**
         * @param candidates 候选数组
         * @param begin      从候选数组的 begin 位置开始搜索
         * @param target     表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
         * @param path       从根结点到叶子结点的路径
         */
        private void dfs(int[] candidates, int begin, int target, ArrayList<Integer> path) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
                if (target - candidates[i] < 0) {
                    break;
                }

                // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                path.add(candidates[i]);
                // 调试语句 ①
                // System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

                // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
                dfs(candidates,i + 1, target - candidates[i], path);

                path.remove(path.size() - 1);
                // 调试语句 ②
                // System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
            }
        }
    }

}
