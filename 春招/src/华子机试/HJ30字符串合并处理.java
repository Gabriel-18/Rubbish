package 华子机试;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class HJ30字符串合并处理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
//        System.out.println(s1);
//        System.out.println(s2);
        String s3 = s1 + s2;
        ArrayList<Character> odd = new ArrayList<>();
        ArrayList<Character> even = new ArrayList<>();
        for (int i = 0; i < s3.length(); i += 2) {
            char ch = s3.charAt(i);
            odd.add(ch);
        }
        odd.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });
        for (int i = 1; i < s3.length(); i += 2) {
            char ch = s3.charAt(i);
            even.add(ch);
        }
        even.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s3.length(); i++) {
            if (odd.size() > i) {
                sb.append(odd.get(i));
            }
            if (even.size() > i) {
                sb.append(even.get(i));
            }
        }
        String s = sb.toString();
//        String target = s.toLowerCase();
        HashMap<Character, String> map = new HashMap<>();
        map.put('0',"0000");
        map.put('1',"0001");
        map.put('2',"0010");
        map.put('3',"0011");
        map.put('4',"0100");
        map.put('5',"0101");
        map.put('6',"0110");
        map.put('7',"0111");
        map.put('8',"1000");
        map.put('9',"1001");
        map.put('a',"1010");
        map.put('b',"1011");
        map.put('c',"1100");
        map.put('d',"1101");
        map.put('e',"1110");
        map.put('f',"1111");
        map.put('A',"1010");
        map.put('B',"1011");
        map.put('C',"1100");
        map.put('D',"1101");
        map.put('E',"1110");
        map.put('F',"1111");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                String s4 = map.get(ch);
                StringBuffer f = new StringBuffer(s4);
//            StringBuffer f1 = f.reverse();
//            System.out.println(f);
                int num = 0;
                for (int j = 0; j < f.length(); j++) {
                    char c = f.charAt(j);
                    int n = c - '0';
                    num += Math.pow(2,j) * n;
                }
                if (num >= 0 && num <= 9) {
                    System.out.print(num);
                } else if (num >= 10 && num <= 15) {
                    char c = (char) (num - 10 + 'A');
                    System.out.print(c);
                }
            } else {
                System.out.print(ch);
            }


        }
    }
}
