package leetcode;

import java.util.HashSet;

public class ContainsDuplicate {
    /**
     * 217. Contains Duplicate
     * https://leetcode.com/problems/contains-duplicate/
     * 利用set去重
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}
