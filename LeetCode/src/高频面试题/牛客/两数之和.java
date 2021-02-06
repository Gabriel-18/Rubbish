package 高频面试题.牛客;

import java.util.HashMap;

public class 两数之和 {
    // 数字从1开始
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target-numbers[i]) + 1,i +1 };
            } else {
                map.put(numbers[i],i);
            }
        }
        return null;
    }
}
