package 华子机试;

import java.util.Scanner;

public class HJ16购物单 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(";");
        int x = 0;
        int y = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("[AWSD][0-9]*")) {
                String first = split[i].substring(0, 1);
                Integer integer = Integer.valueOf(split[i].substring(1));
                if ("A".equals(first)) {
                    x -= integer;
                } else if ("D".equals(first)) {
                    x += integer;
                } else if ("W".equals(first)) {
                    y += integer;
                } else if ("S".equals(first)) {
                    x -= integer;
                }
            }
        }
        System.out.println(x+"," +y);
    }
}
