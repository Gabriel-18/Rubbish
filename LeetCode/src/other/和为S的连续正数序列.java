package other;

import java.util.ArrayList;


/*
用两个数字start和end分别表示序列的最小值和最大值，
首先将start初始化为1，end初始化为2.
因为我是从小开始遍历的
如果从start到end的和大于s，我们就从序列中去掉较小的值(即增大start),
相反，只需要增大end。
终止条件为：一直增加start到(1+sum)/2并且end小于sum为止
*/
public class 和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;

        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
                // curSum == sum
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                // 下一轮的开始
                // 更改状态
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
