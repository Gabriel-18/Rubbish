package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目要求返回具体的那个字符
 * 散列统计次数
 * 用队列来维护这个顺序
 * 保证队元素不重复
 * 当队首的元素出现的次数大于1时 就开始执行淘汰策略
 */
public class 字符流中第一个不重复的字符 {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
