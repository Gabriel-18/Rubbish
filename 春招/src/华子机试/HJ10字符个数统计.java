package 华子机试;

import java.util.HashMap;
import java.util.Scanner;

public class HJ10字符个数统计 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),0);
        }
        int cnt = 0;
        for (Character character : map.keySet()) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
