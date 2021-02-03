package other;

import java.util.ArrayList;
import java.util.List;


/*
用两个数字start和end分别表示序列的最小值和最大值，
首先将start初始化为1，end初始化为2.
因为我是从小开始遍历的
如果从start到end的和大于s，我们就从序列中去掉较小的值(即增大start),
相反，只需要增大end。
终止条件为：一直增加start到(1+sum)/2并且end小于sum为止



update: 上面废话太多
极限情况就是一个数
所以curSum > sum 只能减少start 更新curSum
curSum < sum 只能增加end 更新curSum
curSum == sum 直接收集结果

更新规则 加新值 减旧值
更新窗口
*/
public class 和为S的连续正数序列 {



    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = start + end;

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


    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2;
        int curSum = i + j;
        List<int[]> res = new ArrayList<>();

        while (j < target) {
            if (curSum < target) {
                j++;
                curSum += j;
            } else if (curSum > target) {
                curSum -= i;
                i++;
            } else {
                int[] list = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    list[k - i] = k;
                }
                res.add(list);

                j++;
                curSum += j;

                curSum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public String reverseWords(String s) {
        int st = 0;
        int n = s.length();
        if(n == 0) return "";
        ArrayList<String> l = new ArrayList<>();
        for(int i = 0;i < n;) {
            while(i < n && s.charAt(i) == ' ') {
                i++;
            }
            if(i == n) break;
            //System.out.println(st);
            st = i;
            while(i < n&& s.charAt(i) != ' ') {
                i++;
            }
            l.add(s.substring(st, i));
            //System.out.println(s.substring(st, i));
        }
        //for(String i:l) System.out.println(i);
        StringBuilder sb = new StringBuilder();
        int size = l.size();
        for(int i = size-1;i > 0;i--) {
            sb.append(l.get(i));
            sb.append(" ");
        }
        if(size > 0)sb.append(l.get(0));
        return sb.toString();
    }
}
