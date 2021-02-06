package leetcode.sort;

import java.util.Arrays;
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
        // 小顶堆? 堆相关知识 得补一下
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

    public int findKthLargest2(int[] nums, int k) {
        // 先排序
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 快排依旧不熟
    public int findKthLargest3(int[] nums, int k) {
       k = nums.length - k;
       int l = 0, h = nums.length - 1;
       while (l < h) {
           int j = partition(nums, l, h);
           if (j == k) {
               break;
           } else if (j < k) {
               l = j + 1;
           } else {
               h = j - 1;
           }
       }
       return nums[k];
    }

    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l);
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
