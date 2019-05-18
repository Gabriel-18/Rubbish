package sorting.shellsort;

import sorting.Sort;

public class Shell<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        // Sort a[] into increasing order
        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            // 1 , 4, 13, 40, 121, 364, 1093....
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j],nums[j - h]); j -= h) {
                   swap(nums, j, j - h);
                }
            }
        }
    }
}
