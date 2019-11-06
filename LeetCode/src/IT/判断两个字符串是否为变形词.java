package IT;

import java.util.Scanner;

public class 判断两个字符串是否为变形词 {
    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] chars = str1.toCharArray();
        char[] chars1 = str2.toCharArray();
        int[] map = new int[256];

        for (int i = 0; i < chars.length; i++) {
            map[chars[i]]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (map[chars1[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n2 = scanner.nextInt();
        String str1 = scanner.next();
        String str2 = scanner.next();
        boolean deformation = isDeformation(str1, str2);
        System.out.println(deformation);

    }
}
