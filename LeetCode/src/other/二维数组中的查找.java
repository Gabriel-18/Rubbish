package other;

import org.junit.Test;

public class 二维数组中的查找 {

    int [][] array = {
        {1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    };
    @Test
    public void test() {
        Find(5, array);
    }
    public boolean Find(int target, int [][] array) {
        // 边界检测
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }


        int rows = array.length, cols = array[0].length;
        int r = 0, c = cols - 1;// 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                r++;
                // target < array[r][c]
            } else {
                c--;
            }
        }
        return false;
    }
}
