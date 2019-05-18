package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * https://leetcode.com/problems/permutations/
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helpers(res, new ArrayList<Integer>(), nums);
        return res;
    }

    private void helpers(List<List<Integer>> res, ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helpers(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
