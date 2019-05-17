package sort.Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

/**
 * 只有k个数的优先队列的第一个元素就是第k大的数
 * 时间复杂度 O(NlogK)，空间复杂度 O(K)。
 */
public class solution {
    public int findKthLargest(int[] nums, int k) {
        //小顶堆 翻一下源码
        // The <em>head</em> of this queue is the <em>least</em> element with respect to the specified ordering.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int var : nums) {
            priorityQueue.add(var);
            if (priorityQueue.size() > k) {
                //维护堆的大小
                priorityQueue.poll();
            }
        }
        //返回队顶元素
        return priorityQueue.peek();

    }
    //public int findKthLargest2(int[] nums, int k) {
    //    k = nums.length - k;
    //    int l = 0, h = nums.length - 1;
    //    while (l < h) {
    //        int j =
    //    }
    //}
}
