package 华子机试;

import java.util.Scanner;

public class HJ6质数因子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = n;
        int i;
        for (i = 2; i * i <= n1; i++) {
            while (n % i == 0) {
                n = n / i;
                System.out.printf("%d ",i);
            }
        }
        if (n != 1) {
            System.out.println(n);
        }
    }
}
