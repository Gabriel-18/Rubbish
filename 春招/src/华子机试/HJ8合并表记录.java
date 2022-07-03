package 华子机试;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8合并表记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            map.put(k,map.getOrDefault(k,0) + v);
        }
        for (Integer integer : map.keySet()) {
            System.out.printf("%d %d\n",integer, map.get(integer));
        }
    }
}
