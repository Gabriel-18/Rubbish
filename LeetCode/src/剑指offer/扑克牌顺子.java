package 剑指offer;

import java.util.Arrays;

/**
 * 以大小王为 0,0 可以代替任何数字。
 * 先对序列进行排序，然后算数组中 0 的个数，计算数组空缺 总数，
 * 如果空缺总数大于 0 的个数，不是顺子，否则是顺子。
 * 注意如果 5 张牌发现有 对子，肯定不是顺子
 */
public class 扑克牌顺子 {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        // 统计
        int cnt = 0;
        for (int number : numbers) {
            if (number == 0) {
                cnt++;
            }
        }

        for (int i = cnt; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            cnt -= numbers[i + 1] - numbers[i] - 1;
        }
        return cnt >= 0 ;
    }
}
