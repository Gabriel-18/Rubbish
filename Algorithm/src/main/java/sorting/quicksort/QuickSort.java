package sorting.quicksort;

import sorting.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        // shuffle needed for performance guarantee
        shuffle(nums);
        sort(nums, 0, nums.length - 1);

    }

    /**
     * 快排
     * @param nums 待排序的数组
     * @param l 左边界
     * @param h 右边界
     */
    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }

        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);

    }

    /**
     * 把数组打乱
     * @param nums 待排序的数据
     */
    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    /**
     * 取 a[l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，
     * 再从数组的右端向左扫描找到第一个小于它的元素，交换这两个元素。
     * 不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。
     *  当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置。
     * @param nums 被随机打乱的数组
     * @param l 左边界
     * @param h 右边界
     * @return 切分
     */
    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[i];
        while (true) {
            // find item on left to swap
            while (less(nums[++i], v) && i != h) {
                ;
            }

            // find item on right to swap
            while (less(v, nums[--j]) && j != i) {
                ;
            }

            // check if pointers cross
            if (i >= j) {
                break;
            }

            //swap
            swap(nums, i, j);
        }

        // swap with partitioning item
        swap(nums, i, j);
        // return index of item known to be in place
        return j;
    }

    public static void main(String[] args) {

    }

    /**
     * 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。
     *
     * 可以利用这个特性找出数组的第 k 个元素。
     *
     * 该算法是线性级别的，假设每次能将数组二分，那么比较的总次数为 (N+N/2+N/4+..)，直到找到第 k 个元素，这个和显然小于 2N
     * @param nums
     * @param k
     * @return
     */
    public T select(T[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);

            if (j == k) {
                return nums[k];

            } else if (j > k) {
                h = j - 1;

            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }
}
