package 华子机试;

import java.util.Scanner;

public class HJ22汽水瓶 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = sc.nextInt();
            if (n == 0) break;
            System.out.println(n / 2);
        }
    }
}
