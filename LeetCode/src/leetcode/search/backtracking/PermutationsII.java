package leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//在实现上，和 Permutations 不同的是要先排序，然后在添加一个元素时，
// 判断这个元素是否等于前一个元素，
// 如果等于，并且前一个元素还未访问，那么就跳过这个元素。
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
            // A B B
            // 1 2 3
            // 1 3 2 X
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
