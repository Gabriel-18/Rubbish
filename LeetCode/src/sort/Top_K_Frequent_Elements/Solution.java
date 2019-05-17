package sort.Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/solution/
 * 设置若干个桶，每个桶存储出现频率相同的数，并且桶的下标代表桶中数出现的频率，
 * 即第 i 个桶中存储的数出现的频率为 i。
 *
 * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num: nums) {
            //Returns the value to which the specified key is mapped,
            // or defaultValue if this map contains no mapping for the key.
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            //即第 i 个桶中存储的数出现的频率为 i。
            buckets[frequency].add(key);
        }
        // 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
        List<Integer> topk = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topk.size() < k; i--) {
            // 没有存
            if (buckets[i] == null) {
                continue;
            }

            // 可以全部接受
            if (buckets[i].size() <= (k - topk.size())) {
                // 更新
                topk.addAll(buckets[i]);
                //部分接收
            } else {
                // 更新
                topk.addAll(buckets[i].subList(0, k - topk.size()));
            }
        }
        return topk;
    }
}
