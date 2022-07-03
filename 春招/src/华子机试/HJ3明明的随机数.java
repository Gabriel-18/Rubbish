package 华子机试;

import java.util.Scanner;
import java.util.TreeSet;

public class HJ3明明的随机数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> nums = new TreeSet<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            nums.add(num);
        }

        for (Integer num : nums) {
            System.out.println(num);
        }
    }
}
