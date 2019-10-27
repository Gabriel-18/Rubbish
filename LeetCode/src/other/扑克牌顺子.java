package other;

import java.util.Arrays;

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
