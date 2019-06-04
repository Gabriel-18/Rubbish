package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     * https://leetcode.com/problems/longest-consecutive-sequence/solution/
     * 128. Longest Consecutive Sequence
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, 1);
        }

        for (int num : nums) {
            forward(countForNum, num);
        }

        return maxCount(countForNum);
    }

    private int maxCount(HashMap<Integer, Integer> countForNum) {
        int max = 0;
        for (int num : countForNum.keySet()) {
            max = Math.max(max, countForNum.get(num));
        }
        return max;
    }

    private int forward(HashMap<Integer, Integer> countForNum, int num) {
        if (!countForNum.containsKey(num)) {
            return 0;
        }
        int cnt = countForNum.get(num);
        if (cnt > 1) {
            return cnt;
        }
        // + 1继续执行
        cnt = forward(countForNum,num+1 ) + 1;
        countForNum.put(num, cnt);
        return cnt;
    }

    /***
     * 优点在于查询上
     * 比较的方式很常规
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStack = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStrek = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStrek += 1;
                }
                longestStack = Math.max(longestStack, currentStrek);
            }

        }
        return longestStack;
    }
}
