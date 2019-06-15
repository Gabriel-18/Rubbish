package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    /**
     * 215. Kth Largest Element in an Array
     * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
     * 找出倒数第k个数
     * 如果用小顶堆的话 去掉前k-1个数 就行了
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆?
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) {
                // 最小的出列
                pq.poll();
            }
        }
        return pq.peek();
    }
}
