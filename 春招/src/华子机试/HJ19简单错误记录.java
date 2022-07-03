package 华子机试;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HJ19简单错误记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNextLine()){
            String[] split = sc.nextLine().split("\\\\");
            String target = split[split.length - 1];
            String[] s = target.split(" ");
            int length = s[0].length();
            int i = 0;
            if (length > 16) {
                 i = length - 16;
            }
            String key = s[0].substring(i);
            key = key + " " + s[1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key,1);
            }
        }
        int cnt = 0;
        for (String s : map.keySet()) {
            cnt++;
            if (cnt > (map.keySet().size() - 8)) {
                System.out.println(s + " " + map.get(s));
            }
        }
    }
}

