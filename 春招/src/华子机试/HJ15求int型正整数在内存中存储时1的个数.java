package 华子机试;

import java.util.Scanner;

public class HJ15求int型正整数在内存中存储时1的个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        System.out.println(count);
    }
}
