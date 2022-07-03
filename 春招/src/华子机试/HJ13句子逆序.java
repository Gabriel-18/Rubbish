package 华子机试;

import java.util.Scanner;

public class HJ13句子逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        for (int i = s1.length - 1; i >= 0 ; i--) {
            System.out.print(s1[i] + " ");
        }
    }
}
