package 高频面试题.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        int res = 0;
        for(int num : nums){
            if(set.contains(num - 1))
                continue;
            else{
                //len记录以num为左边界的连续序列的长度
                int len = 0;
                while(set.contains(num++))
                    len++;
                res = Math.max(res, len);
            }
        }
        return res;
    }

}
