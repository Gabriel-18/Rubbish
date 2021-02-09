package 高频面试题.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
