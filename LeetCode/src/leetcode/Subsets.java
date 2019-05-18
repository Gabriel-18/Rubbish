package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * 78. Subsets
     * https://leetcode.com/problems/subsets/
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums,i + 1);
            list.remove(list.size() - 1);
        }
    }
}
