package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    /**
     * https://leetcode.com/problems/combination-sum-iii/
     * 216. Combination Sum III
     * 这三道题一个套路
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(),k,n,1);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (n < 0 || k < 0) {
            return;
        }
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
    @Test
    public void test() {
        List<List<Integer>> lists = combinationSum3(3, 9);
        System.out.println(lists);
    }
}
