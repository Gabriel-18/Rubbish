package 华子机试;

import java.util.Scanner;

public class HJ5进制转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String substring = s.substring(2);
        StringBuffer sb = new StringBuffer(substring);
        sb = sb.reverse();
        int sum = 0;
        int num = 0;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch > '9') {
                num = ch - 'A' + 10;
            } else {
                num = ch - '0' ;
            }
            sum += num * Math.pow(16,i);
        }
        System.out.println(sum);
    }
}
