package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations2 {
    /**
     * https://leetcode.com/problems/permutations/
     * @param
     * @return
     */
    private ArrayList<List<Integer>> res;
    private boolean[] used;
    
    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);

        return res;
    }

    // p 保存index - 1个元素的排列
    // 向其添加第index个元素
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {

        if(index == nums.length){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (!used[i]) {
                used[i] = true;
                p.add(nums[i]);
                generatePermutation(nums, index + 1, p);
                p.removeLast();
                used[i] = false;
            }
        }
        return;
    }
}
