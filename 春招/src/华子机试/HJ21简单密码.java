package 华子机试;

import java.util.HashMap;
import java.util.Scanner;

public class HJ21简单密码 {
    public static void main(String[] args) {
        int n = 'a';
        int n1 = 'A';
        HashMap<String, Integer> map = new HashMap<>();
        map.put("abc",2);
        map.put("def",3);
        map.put("ghi",4);
        map.put("jkl",5);
        map.put("nmo",6);
        map.put("qprs",7);
        map.put("tuv",8);
        map.put("wxyz",9);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
//            StringBuilder sb = new StringBuilder();
//            sb.append(ch);
            if (ch >= 'a' && ch <= 'z') {
                for (String s1 : map.keySet()) {
                    if (s1.contains(String.valueOf(ch))) {
                        System.out.print(map.get(s1));
                        break;
                    }
                }
            } else if (ch >= '0' && ch <= '9') {
                System.out.print(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                ch += 32;
                if (ch == 'z') {
                    System.out.print("a");
                } else {
                    ch++;
                    System.out.print(ch);
                }
            }

        }
    }
}
