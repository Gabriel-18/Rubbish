package 华子机试;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ26字符串排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String res = sort(str);
            System.out.println(res);
        }
    }

    private static String sort(String str) {
        // 收集英语字符
        ArrayList<Character> letters = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.add(ch);
            }
        }

//        letters.sort(Comparator.comparingInt(Character::toLowerCase));
        letters.sort((o1, o2) -> Character.toLowerCase(o1) - Character.toLowerCase(o2));

        StringBuffer sb = new StringBuffer();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                sb.append(letters.get(j++));
            } else {
                // 非英语字符直接添加
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
