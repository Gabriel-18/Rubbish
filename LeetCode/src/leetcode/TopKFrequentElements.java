package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    /**
     * 347. Top K Frequent Elements
     * https://leetcode.com/problems/top-k-frequent-elements/
     * 把数都放到桶之后，从后向前遍历桶，
     * 最先得到的 k 个数就是出现频率最多的的 k 个数
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        //设置若干个桶，每个桶存储出现频率相同的数。
        // 桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            //  return the value to which the specified key is mapped, or
            //  {@code defaultValue} if this map contains no mapping for the key
            frequencyForNum.put(num,frequencyForNum.getOrDefault(num, 0)+ 1 );
        }
        // 把数放进桶里
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        //把数都放到桶之后，从后向前遍历桶，
        // 最先得到的 k 个数就是出现频率最多的的 k 个数。
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }


}
