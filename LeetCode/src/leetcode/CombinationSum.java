package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /**
     * 39. Combination Sum
     * https://leetcode.com/problems/combination-sum/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        helpers(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helpers(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helpers(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
    @Test
    public void test() {
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> lists = combinationSum(candidates, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
