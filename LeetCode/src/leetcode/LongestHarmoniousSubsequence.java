package leetcode;

import java.util.HashMap;

/**
 *  *https://leetcode.com/problems/longest-harmonious-subsequence/description/
 *  594. Longest Harmonious Subsequence
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num,0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)){
                longest = Math.max(longest, countForNum.get(num) + countForNum.get(num + 1));
            }
        }
        return longest;
    }
}
