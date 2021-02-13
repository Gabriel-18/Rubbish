package 高频面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _46全排列 {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return ret;
        }
        boolean[] marked = new boolean[nums.length + 1];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(nums, marked, list);
        return ret;
    }

    private void dfs(int[] nums, boolean[] marked,ArrayList<Integer> list) {
        if (nums.length == list.size()) {
            ret.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (marked[i] == false) {
                    marked[i] = true;
                    list.add(nums[i]);
                    dfs(nums, marked, list);
                    marked[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
