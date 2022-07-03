package 华子机试;

import java.util.HashMap;
import java.util.Scanner;

public class HJ23删除字符串中出现次数最少的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int min  = 21;
        for (Character character : map.keySet()) {
            Integer n = map.get(character);
            if (n < min) {
                min = n;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int n = map.get(ch);
            if (n == min) {
                continue;
            }
            System.out.print(ch);
        }
    }
}
