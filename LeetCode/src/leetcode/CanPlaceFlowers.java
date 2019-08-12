package leetcode;

public class CanPlaceFlowers {
    /**
     * https://leetcode.com/problems/can-place-flowers/description/
     *605. Can Place Flowers
     * 首先解读一下题目
     *0是可以种的地方
     * 1是已经被使用的
     *大前提 无非关注当前位置的前和后
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;

        for (int i = 0; i < len && cnt < n; i++) {
            // 被使用过的跳过
            if (flowerbed[i] == 1) {
                continue;
            }

            // 判断当前位置是否为0 如果是显然他前面的那位置可以理解为空 相当于特判 这样写 就是简洁吧
            // 如果不是则去取当前位置前面的值
            // 前一个
            int pre = i == 0 ? 0 : flowerbed[i - 1];

            // 当处于最好一个位置 情况和上面类似
            // 只是注意数组从0开始的
            // 这种解法思想其实很朴素 只是写法上面可能不太习惯
            int next = i == len - 1 ? 0 : flowerbed[i + 1];

            // 满足更新条件
            if (pre == 0 && next == 0) {
                cnt++;
                // 标志已经中过
                flowerbed[i] = 1;
            }
        }
        // 判断
        return cnt >= n;
    }
}
