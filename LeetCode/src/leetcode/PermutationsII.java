package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    /**
     * https://leetcode.com/problems/permutations-ii/
     * 对比上一道 这道只是多了去重
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 排序为去重
        Arrays.sort(nums);
        heleper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void heleper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            // user[i] 当前是否被用过
            // i > 0 && nums[i] == nums[i - 1] && !used[i - 1] 是否重复
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            heleper(res,list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
