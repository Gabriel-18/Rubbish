package 华子机试;

import java.util.Scanner;

public class HJ1字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        String target = s[s.length - 1];
        System.out.println(target.length());
    }

}
