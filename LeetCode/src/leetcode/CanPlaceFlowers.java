package leetcode;

public class CanPlaceFlowers {
    /**
     * https://leetcode.com/problems/can-place-flowers/description/
     *605. Can Place Flowers
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;

        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            // 前一个
            int pre = i == 0 ? 0 : flowerbed[i - 1];

            // 后一个
            int next = i == len - 1 ? 0 : flowerbed[i + 1];

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
