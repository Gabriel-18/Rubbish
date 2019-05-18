package sorting.bubblesort;

import sorting.Sort;

/**
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 *
 * 在一轮循环中，如果没有发生交换，就说明数组已经是有序的，此时可以直接退出
 * @param <T>
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean hasSorted = false;
        for (int i = N - 1; i > 0 && !hasSorted; i--) {
            hasSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    hasSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {2,1,2,33,44};
        for (Integer integer : a) {
            System.out.println(integer);
        }
        System.out.println("===============");
        Bubble<Integer> integerBubble = new Bubble<>();
        integerBubble.sort(a);
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }

}
