package sorting.mergesort;

import sorting.Sort;

public  abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] aux;
    // Merge a[lo..mid] with a[mid+1..hi].
    protected void merge(T[] nums, int l, int m, int h) {
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = nums[k];
        }

        // Merge back to a[lo..hi].
        for (int k = l; k <= h; k++) {
            if (i > m)
                nums[k] = aux[j++];
            else if (j < m)
                nums[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) <= 0) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }



}
