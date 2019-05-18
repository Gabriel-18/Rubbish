package sorting.mergesort;

public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        aux = (T[]) new Comparable[N];

        for (int sz = 1; sz < N; sz += sz + sz) { // sz: subarray size
            for (int lo = 0;lo < N - sz; lo += sz + sz) { // lo: subarray index
                merge(nums, lo, lo + sz - 1,Math.min(lo + sz + sz - 1, N - 1) );
            }
        }
    }
}
