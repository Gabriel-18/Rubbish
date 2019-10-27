package other;


public class 数字在排序数组中出现的次数 {
    public int GetNumberOfK(int [] array , int k) {
        int first = binarySearch(array, k);
        int last = binarySearch(array, k + 1);
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }

    private int binarySearch(int[] array, int k) {
        int l = 0, h = array.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (array[m] >= k) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
