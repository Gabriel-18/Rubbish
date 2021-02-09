package 剑指offer.dp;

public class 矩形覆盖 {
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int pre2 = 2, pre1 = 1;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
