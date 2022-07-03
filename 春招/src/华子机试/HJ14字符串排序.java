package 华子机试;

import java.util.*;

public class HJ14字符串排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            strings[i] = s;
        }
        Arrays.sort(strings);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
