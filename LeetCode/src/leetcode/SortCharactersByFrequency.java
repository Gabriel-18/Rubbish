package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    /**
     * 451. Sort Characters By Frequency
     * https://leetcode.com/problems/sort-characters-by-frequency/
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        // 统计频率
        for (char c : s.toCharArray()) {
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }

        // 开始统计
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];

        for (char c : frequencyForNum.keySet()) {
            // 将频率相同的放在一个桶吧
            int f = frequencyForNum.get(c);
            // 第一次处理时
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            // 将相同频率的添加到一起
            frequencyBucket[f].add(c);
        }
        // 逆序 因为要从高频开始输出
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            // 忽略不存在的
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }

        }

        return str.toString();
    }
}
