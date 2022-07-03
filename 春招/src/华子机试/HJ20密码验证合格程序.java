package 华子机试;

import java.util.Scanner;

public class HJ20密码验证合格程序 {
    private static boolean restr(String s) {
        for (int i = 3; i < s.length(); i++) {
            // 不能有长度大于2的包含公共元素的子串重复
            if (s.substring(i).contains(s.substring(i - 3, i))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.length() < 8) {
                System.out.println("NG");
            } else {
                int a = 0, b = 0, c = 0, d = 0;
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    if (ch >= '0' && ch <= '9') {
                        a = 1;
                    } else if(ch >= 'a' && ch <= 'z') {
                        b = 1;
                    } else if(ch >= 'A' && ch <= 'Z') {
                        c = 1;
                    } else if(ch == ' ' || ch == '\n') {
                        System.out.println("NG");
                        continue;
                    } else {
                        d = 1;
                    }
                }

                if (a + b + c + d >= 3) {
                    if (restr(s)) {
                        System.out.println("OK");
                    } else {
                        System.out.println("NG");

                    }
                } else {
                    System.out.println("NG");
                }

            }

        }
    }
}
