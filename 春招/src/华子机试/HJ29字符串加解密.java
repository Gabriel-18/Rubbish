package 华子机试;

import java.util.Scanner;

public class HJ29字符串加解密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(encryption(s1));
        System.out.println(deciphering(s2));
    }

    private static String deciphering(String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = Character.toUpperCase(ch);
                    if (c == 'A') {
                        c = 'Z';
                    } else {
                        c = (char) (c - 1);
                    }
                    sb.append(c);
                } else if (Character.isUpperCase(ch)) {
                    char c = Character.toLowerCase(ch);
                    if (c == 'a') {
                        c = 'z';
                    } else {
                        c = (char) (c - 1);
                    }
                    sb.append(c);
                }
            } else if (Character.isDigit(ch)) {
                if (ch == '0') {
                    ch = '9';
                } else {
                    ch = (char) (ch - 1);
                }
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private static String encryption(String s1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = Character.toUpperCase(ch);
                    if (c == 'Z') {
                        c = 'A';
                    } else {
                        c = (char) (c + 1);
                    }
                    sb.append(c);
                } else if (Character.isUpperCase(ch)) {
                    char c = Character.toLowerCase(ch);
                    if (c == 'z') {
                        c = 'a';
                    } else {
                        c = (char) (c + 1);
                    }
                    sb.append(c);
                }
            } else if (Character.isDigit(ch)) {
                if (ch == '9') {
                    ch = '0';
                } else {
                    ch = (char) (ch + 1);
                }
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
