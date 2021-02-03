package other.arrays;

public class 二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        // 边界检测
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int rows = array.length, cols = array[0].length;
        // 从右上角开始
        int r = 0, c = cols - 1;
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
