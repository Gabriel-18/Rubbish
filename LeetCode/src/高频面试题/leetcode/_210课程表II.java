package 高频面试题.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _210课程表II {
    // 方法 1 最简单的 BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) {
            // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()){
            int curr = queue.poll();
            // 将可以学完的课程加入结果当中
            res[count++] = curr;
            for (int[] p : prerequisites) {
                // 之前需要学curr的
                // 减少学习次数
                if (p[1] == curr){
                    inDegrees[p[0]]--;
                    // 为0时 加入待输出队列
                    if (inDegrees[p[0]] == 0) {
                        queue.offer(p[0]);
                    }
                }
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

}
