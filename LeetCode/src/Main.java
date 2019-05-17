import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> res;

    static void dfs(int[] arr, int depth, int cur, int n, ArrayList<Integer> curr) {
        if (depth == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            curr.add(arr[i]); //当前 d 层元素为nums[i]
            dfs(arr, depth + 1, i + 1, n, curr); //去考虑d+1以及后面的层，注意下次直接从i+1开始，不会有重复的
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        PrintStream out = System.out;

        //int[] arr = {2, 1, 3};
        int[] arr = {1, 2, 3};

        res = new ArrayList<>();
        dfs(arr, 0, 0, 3, new ArrayList<>()); // 从3个数中取3个数的组合(不是排列)
        out.println(res);

        out.println("-------------------------------");

        res = new ArrayList<>();
        dfs(arr, 0, 0, 2, new ArrayList<>());// 从3个数中取2个数的组合(不是排列)
        out.println(res);
    }
}