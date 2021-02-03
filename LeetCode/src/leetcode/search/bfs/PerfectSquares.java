package leetcode.search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquares {
    /**
     * 279. Perfect Squares
     * https://leetcode.com/problems/perfect-squares/
     * 用深度表示个数
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        List<Integer> squres = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            while (size-- > 0) {
                // Retrieves and removes the head of this queue,
                int cur = queue.poll();

                for (int s : squres) {
                    // 一个大的平方数 - 一个小的平方数
                    int next = cur - s;

                    // 小于0的话 这个数不可能由平分数加出来
                    if (next < 0) {
                        break;
                    }

                    // 恰好此时这个数是组成该平方数的部分
                    if (next == 0) {
                        return level;
                    }

                    // 这个数出现过无妨再测
                    if (marked[next]) {
                        continue;
                    }

                    // 标记使用过
                    marked[next] = true;
                    // 加入队列
                    queue.add(next);
                }

            }
        }
        return n;
    }

    /**
     * 生成小于n的平方数序列
     * 利用连续奇数和
     * @param n
     * @return
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares  = new ArrayList<>();
        int square = 1;
        int diff = 3;

        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

    public int numSquares2(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            Integer cur = queue.poll();
            for (Integer s : squares) {
                int next = cur - s;
                if (next < 0) {
                    break;
                }
                if (next == 0) {
                    return level;
                }
                if (marked[next]) {
                    continue;
                }
                marked[next] = true;
                queue.add(next);
            }
        }
        return n;
    }
}
