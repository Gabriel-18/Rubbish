package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /**
     * 39. Combination Sum
     * https://leetcode.com/problems/combination-sum/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        // 排序为去重做准备
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 重复的不做
            if (i != start  && candidates[i] == candidates[i - 1] ) {
                continue;
            }
            list.add(candidates[i]);
            // 不可以重复从i+!开始
            helper(res, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
    @Test
    public void test(){

        int[] candidates = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2(candidates,8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
