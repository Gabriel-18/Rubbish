package 高频面试题.leetcode;

public class _134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0;
        int sum = 0;
        int start = 0;
        int N = gas.length;
        for (int i = 0; i < N; i++) {
            // 全局
            total += gas[i] - cost[i];
            // 当前
            sum += gas[i] - cost[i];
            if (sum < 0) {
                // meaning any point from last start to i is unfeasible
                start = i + 1;
                sum = 0;
            }
        }

        return total >= 0 ? start : -1;

    }

}
