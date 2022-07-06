package 华子机试;

import java.util.Scanner;

import static java.lang.System.in;

public class HJ31单词倒排 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        String s = scanner.nextLine();
        String[] target = s.split("[^A-Za-z]+");
        for (int i = target.length - 1; i >= 0 ; i--) {
            System.out.print(target[i] + " ");
        }
    }
}
