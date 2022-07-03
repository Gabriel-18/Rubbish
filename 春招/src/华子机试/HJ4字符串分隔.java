package 华子机试;

import java.util.Scanner;

public class HJ4字符串分隔 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            idx++;
            if (idx % 8 == 0) {
                System.out.println();
            }
        }
        int num = s.length() % 8 == 0 ? 0 : 8 -  s.length() % 8;
        for (int i = 0; i < num; i++) {
            System.out.print(0);
        }

    }

}
