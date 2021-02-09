package 剑指offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return ret;
        }
        findKthSmallest(input, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    /***
     * 目标就是找到第k大的元素
     * 快速排序的 partition () 方法，会返回一个整数 j 使得 a [l..j-1] 小于等于 a [j]，且 a [j+1..h] 大于等于 a [j]，
     * 此时 a [j] 就是数组的第 j 大元素。
     * 可以利用这个特性找出数组的第 K 个元素，这种找第 K 个元素的算法称为快速选择算法。
     * @param nums
     * @param k
     */
    private void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            // 不需要管比k的大的那部分了
            // 所以j - 1
            if (j > k) {
                h = j - 1;
            } else {
                // 不需要管比k的小的那部分了
                // 所以j + 1
                l = j + 1;
            }
        }
    }

    /**
     * 快排基础
     * 取 a [l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，
     * 再从数组的右端向左扫描找到第一个小于它的元素，交换这两个元素。
     * 不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。
     * 当两个指针相遇时，将切分元素 a [l] 和 a [j] 交换位置。
     * @param nums
     * @param l
     * @param h
     * @return
     */
    private int partition(int[] nums, int l, int h) {
        int p = nums[l];
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) {
                ;
            }
            while (j != l && nums[--j] > p) {
                ;
            }
            // 可以退出循环了
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }



    /**
     * 复杂度：O (NlogK) + O (K)
     * 特别适合处理海量数据
     *
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
     *
     * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        if (k > input.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : input) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
    public ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return ret;
        }
        findKthSmallest1(input,0,input.length - 1, k);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    private int findKthSmallest1(int[] input, int l, int r, int k) {
        if (l == r) return input[l];
        int x = input[(l + r) >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (input[++i] < x);
            while (input[--j] > x);
            if (i < j) {
                swap(input, i, j);
            }
        }
        int leftSize = j - l + 1;
        if (k <= leftSize) {
            return findKthSmallest1(input, l, j, k);
        } else {
            return findKthSmallest1(input, j + 1, r, k - leftSize);
        }
    }



    public int findKthLargest(int[] nums, int k) {
        return k_quick_sort(nums, 0, nums.length - 1,nums.length - k + 1);

    }
    private int k_quick_sort(int[] nums, int l , int r, int k) {
        if(l == r) return nums[l];
        int i = l - 1, j = r + 1, x = nums[(l + r) >> 1];
        while (i < j) {
            while (nums[++i] < x);
            while (nums[--j] > x);
            if (i < j) {
                swap(nums,i,j);
            }
        }
        int leftSize = j - l + 1;
        if (k <= leftSize) {
            return k_quick_sort(nums, l, j, k);
        } else {
            return k_quick_sort(nums, j + 1, r, k - leftSize);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
