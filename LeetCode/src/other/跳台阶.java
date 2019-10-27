package other;

public class 跳台阶 {
    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre2 = 1, pre1 = 2;
        int result = 1;

        for (int i = 2; i < target; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

}
