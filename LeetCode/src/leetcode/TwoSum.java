package leetcode;

import java.util.HashMap;

public class TwoSum {
    /**
     * 1. Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * time ; O(n)
     * space: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        // to store the result
        int[] res = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        // the method shows that i only has the before res, it's more easy, but hard to understand.
        //for (int i = 0; i < nums.length; i ++) {
        //    if (map.containsKey(target - nums[i])) {
        //        res[0] = map.get(target - nums[i]);
        //        res[1] = i;
        //        break;
        //    }
        //    map.put(nums[i], i);
        //}

        /**
         *  more complicated than the former
         */
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i]) ) {
                res[1] = map.get(target - nums[i]);
                res[0] = i;
                break;
            }
        }
        return res;
    }
}
