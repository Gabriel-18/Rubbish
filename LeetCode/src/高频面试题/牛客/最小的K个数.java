package 高频面试题.牛客;

import java.util.ArrayList;

public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return ret;
        }
        kQuickSort(input, 0, input.length - 1, k);
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }
    private int kQuickSort(int[] q, int l, int r, int k) {
        if (l == r) return q[l];
        int x = q[(l + r )>> 1] , i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x);
            while (q[--j] > x);
            if (i < j) {
                swap(q,i,j);
            }
        }
        int leftSize = j - l + 1;
        if (k <= leftSize) {
            return kQuickSort(q, l, j ,k);
        } else {
            return kQuickSort(q, j + 1, r, k);
        }
    }
    private void swap(int[] q, int i, int j) {
        int t = q[i];
        q[i] = q[j];
        q[j] = t;
    }
}
