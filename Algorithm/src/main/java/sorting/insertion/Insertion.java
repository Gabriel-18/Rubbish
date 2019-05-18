package sorting.insertion;

import sorting.Sort;

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

    public static void main(String[] args) {
        Integer[] a = {2,1,2,33,44};
        for (Integer integer : a) {
            System.out.println(integer);
        }
        System.out.println("===============");
        Insertion<Integer> integerInsertion = new Insertion<>();
        integerInsertion.sort(a);
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }
}
