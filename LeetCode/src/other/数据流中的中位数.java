package other;

import java.util.PriorityQueue;

public class 数据流中的中位数 {
    /**大顶堆 储存左半边元素**/
    private PriorityQueue<Integer> left = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);

    /**
     * 小顶堆 储存右半边元素 且右半边元素都大于左半边
     **/
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /**当前数据流读入的元素个数**/
    private int N = 0;
    public void Insert(Integer num) {
        if (N % 2 == 0) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }

}
