package 华子机试;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ9提取不重复的整数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] array = s.toCharArray();
        ArrayList<Integer> integers = new ArrayList<>(s.length());
        for (int i = array.length - 1; i >= 0; i--) {
            //
            if (!integers.contains(array[i] - '0')) {
                integers.add(array[i] - '0');
            }
        }
        for (Integer integer : integers) {
            System.out.print(integer);
        }
    }
}
