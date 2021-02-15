package 高频面试题.leetcode;

import java.util.HashMap;

public class _560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        // 有负数，不能使用滑动窗口，使用前缀和 + 哈希表登记
        int res = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(nums[0], 1);
        if(nums[0] == k) res++;
        for(int i = 1; i < nums.length; i++){
            // 计算前缀和
            nums[i] += nums[i - 1];

            // 查找是否有连续数组和为k
            if (nums[i] == k) {
                res++;
            }

            if(hash.containsKey(nums[i] - k)){
                res += hash.get(nums[i] - k);
            }

            // 将前缀和加入哈希表
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}
