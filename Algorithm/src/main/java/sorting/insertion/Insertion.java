package sorting.insertion;

import sorting.Sort;

/**
 * Running time insensitive to input. Quadratic time, even if input is sorted.
 * Data movement is minimal. Linear number of exchanges.
 * @param <T>
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        // Sort a[] into increasing order.
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public void sort1(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j],a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {2,1,2,33,44};
        for (Integer integer : a) {
            System.out.println(integer);
        }
        System.out.println("===============");
        Insertion<Integer> integerInsertion = new Insertion<>();
        integerInsertion.sort1(a);
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }
}
