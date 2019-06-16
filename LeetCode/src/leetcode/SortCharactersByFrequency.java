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

        // 开始桶统计
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        // 将频率相同的放在一起
        for (char c : frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            // 相同的
            frequencyBucket[f].add(c);
        }
        // 逆序
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j =- 0; j < i; j++) {
                    str.append(c);
                }
            }

        }

        return str.toString();
    }
}
