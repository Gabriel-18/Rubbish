package 剑指offer;

public class 旋转数组的最小数字 {
    // 2 3 4 1
    // l = 0 h = 3 m = 1
    // l = 2 h = 3 m = 2
    // l = 3 h = 3
    // 综上 嗯？ 我发现我不会二分==！

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0, h = array.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (array[m] <= array[h]) { // 区别于传统的所在
                h = m;
            } else {
                l = m + 1;
            }
        }
        return array[l];
    }

    public int minNumberInRotateArray2(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0, h = array.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (array[l] == array[m] && array[m] == array[h]) {
                return minNumber(array, l, h);
            }
            if (array[m] <= array[h]) { // 区别于传统的所在
                h = m;
            } else {
                l = m + 1;
            }
        }
        return array[l];
    }

    private int minNumber(int[] array, int l, int h) {
        for (int i = l; i < h; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[l];
    }
}
