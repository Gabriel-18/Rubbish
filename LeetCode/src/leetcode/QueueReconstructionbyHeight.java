package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionbyHeight {
    /**
     * 406. Queue Reconstruction by Height
     * https://leetcode.com/problems/queue-reconstruction-by-height/description/
     * 建立排序规则
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        // 身高降序
        // 个数升序
        // a代表升高 第一个 - 第二个 升序排列
        // b代表个数 第二个 - 第一个 降序排列
//        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            // 将学生插入队列的第k个位置中
            queue.add(p[1], p);
        }
        //Returns an array containing all of the elements in this list in
        //proper sequence (from first to last element);
        // 将队列转换成数组形式
        return queue.toArray(new int[queue.size()][]);
    }
}
