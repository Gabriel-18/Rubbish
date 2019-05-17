package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    /**
     * time; nlgn space 1
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
       int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}
