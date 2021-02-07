package 剑指offer;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1) {
            return ret;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        // 已经放入第一个目标值
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            // 去掉每段开头那个值
            heap.remove(num[i]);
            // 添加的位置
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
