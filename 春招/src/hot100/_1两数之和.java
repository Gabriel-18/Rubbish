package hot100;

import java.util.HashMap;

public class _1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        // 暴力法
        for (int i = 0; i < nums.length; i++) {
            // 因为不能重复 所以i + 1
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    // 这样做 能解决问题 但是顺序上面保证不了
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 看源码
            if (map.get(target - nums[i]) != null) {
                // 这样做 能解决问题 但是顺序上面保证不了
///               return new int[]{i,map.get(target - nums[i])};
// 为什么能保证顺序 因为i总是判断后才添加的 自然会比map.get(target - nums[i])大
                return new int[]{map.get(target - nums[i]),i};
            }
            // 防止重复
            // 因为先做判断 再添加就能避免重复
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    // 和方法2没本质区别 使用api上面存在差异
    public int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
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
