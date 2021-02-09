package 剑指offer;

public class 调整数组顺序使奇数位于偶数前面 {

    public void reOrderArray(int [] array) {
        // 奇数个数
        int oddCnt = 0;
        for (int x : array) {
            if (!isEven(x)) {
                oddCnt++;
            }
        }
        int[] copy = array.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }

    }
// 1 2 3 4 5
    // 2 1 3 4 5
    // 2 1 4 3 5
    //
    public void reOrderArray2(int [] array) {
        int N = array.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(array[j]) && !isEven(array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] array, int j, int i) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }
}
