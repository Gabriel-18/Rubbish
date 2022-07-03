package 华子机试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HJ27查找兄弟单词 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(sc.next());
            }
            String s = sc.next();
            char[] chars = s.toCharArray();
            int idx = sc.nextInt();
            Collections.sort(list);
            int count = 0;
            String k = "";
            for (String s1 : list) {
                if (s.equals(s1) || s.length() != s1.length()) {
                    continue;
                }
                char[] strs = s1.toCharArray();
                Arrays.sort(strs);
                Arrays.sort(chars);
                if (!Arrays.equals(strs, chars)) {
                    continue;
                }
                count++;
                if (count == idx) {
                     k = s1;
                }
            }
            System.out.println(count);
            System.out.println(k);
        }

    }
}
