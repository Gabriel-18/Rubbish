package other;

public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int majority = array[0];
        for (int i = 1, cnt = 1; i < array.length; i++) {
            cnt = array[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = array[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for (int val : array) {
            if (val == majority) {
                cnt++;
            }
        }

        return cnt > array.length / 2 ? majority : 0;
    }
}
