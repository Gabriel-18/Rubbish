package sort.Sort_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 * 桶排序
 *  * 设置若干个桶，每个桶存储出现频率相同的数，并且桶的下标代表桶中数出现的频率，
 *  * 即第 i 个桶中存储的数出现的频率为 i。
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        /**
         * 统计频率
         */
        for (char c : s.toCharArray()) {
            /**
             *  * Returns the value to which the specified key is mapped, or
             *    {@code defaultValue} if this map contains no mapping for the key.
             */
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }

        List<Character>[] frequencyBucket  = new ArrayList[s.length() + 1];
        /**
         *
         */
        for (char c: frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            //即第 i 个桶中存储的数出现的频率为 i。
            frequencyBucket[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        // 逆序遍历
        for (int i = frequencyBucket.length - 1; i >= 0 ; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }

            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j ++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
