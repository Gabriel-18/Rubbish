package 华子机试;

import java.util.HashMap;
import java.util.Scanner;

public class HJ2计算某字符出现次数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1 = s.toLowerCase();
        String c = scanner.nextLine();
        String c1 = c.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        int count = map.getOrDefault(c1.charAt(0),0);
        System.out.println(count);
    }
}
